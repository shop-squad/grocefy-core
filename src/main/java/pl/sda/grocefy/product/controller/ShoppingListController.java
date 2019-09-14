package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.service.ShoppingListService;

import java.util.UUID;

@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }


    @RequestMapping("/")
    public ModelAndView getForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newList", new ShoppingListDTO());
        modelAndView.addObject("lists", shoppingListService.getAll());
        return modelAndView;
    }

    @PostMapping("list/new")
    public ModelAndView newList(@ModelAttribute("newList") ShoppingListDTO newList){
        newList.setHash(UUID.randomUUID().toString());
        shoppingListService.addList(newList);
        return new ModelAndView("redirect:/");
    }
}
