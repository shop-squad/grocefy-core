package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.Unit;
import pl.sda.grocefy.product.service.impl.ProductServiceImpl;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final ProductServiceImpl productService;

    public HomeController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @RequestMapping("/a")
    public ModelAndView getHomePage(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("hash", generateHash());
        mav.addObject("units", Unit.values());
        mav.addObject("newList", new ShoppingListDTO());
        mav.addObject("products", productService.getAllProducts());
        return mav;
    }


    private String generateHash(){
        return  LocalDateTime.now().toString();
    }
}
