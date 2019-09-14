package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.service.ItemService;
import pl.sda.grocefy.product.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class AddToListController {

    private final ItemService itemService;
    private final ProductService productService;

    public AddToListController(ItemService itemService, ProductService productService) {
        this.itemService = itemService;
        this.productService = productService;
    }


    @PostMapping("/list/add")
    public ModelAndView addToList(@ModelAttribute("newItem")ItemDTO newItem){
        ModelAndView mav = new ModelAndView("index");
//        ProductDTO productByName = productService.getProductByName(newItem.getProduct().getName());
//        List<ProductDTO> allProducts = productService.getAllProducts();
//        if (productByName != null){
//            Optional<ProductDTO> first = allProducts.stream().filter(productDTO -> productDTO.getName().equalsIgnoreCase(productByName.getName())).findFirst();
//            if (first.isPresent()){
//                newItem.setProduct(first.get());
//            }else {
//                productService.addProduct(newItem.getProduct());
//            }
//        }
        itemService.addItem(newItem);
        return mav;
    }
}
