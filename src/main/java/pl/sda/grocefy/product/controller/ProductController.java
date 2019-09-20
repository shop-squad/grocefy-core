package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public ModelAndView productsList() {
        ModelAndView mav = new ModelAndView("products");
        List<ProductDTO> allProducts = productService.getAllProducts();
        mav.addObject("products", allProducts);
        mav.addObject("newProduct", new ProductDTO());
        return mav;
    }

    @PostMapping("/products")
    public ModelAndView addProduct(@ModelAttribute("newProduct") ProductDTO newProduct) {
        ModelAndView mav = new ModelAndView("redirect:/products");
        List<ProductDTO> allProducts = productService.getAllProducts();
        Long count = allProducts.stream().filter(productDTO -> productDTO.getName().equals(newProduct.getName())).count();
        mav.addObject("productCount", count);
        mav.addObject("products", allProducts);
        if (count != 0L){

            return mav;
        }else {
            productService.addProduct(newProduct);
        }
        return mav;
    }
}
