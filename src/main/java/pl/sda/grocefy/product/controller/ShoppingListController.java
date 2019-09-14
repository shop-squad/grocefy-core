package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.service.ItemService;
import pl.sda.grocefy.product.service.ShoppingListService;

import java.util.UUID;

@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final ItemService itemService;

    public ShoppingListController(ShoppingListService shoppingListService, ItemService itemService) {
        this.shoppingListService = shoppingListService;
        this.itemService = itemService;
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

    @RequestMapping("/list/{hash}")
    public ModelAndView showList(@PathVariable("hash") String hash){
        ModelAndView mav = new ModelAndView("showList");
        mav.addObject("list", shoppingListService.findListByHash(hash));
        mav.addObject("items",itemService.findItemsByListId(shoppingListService.getListIdFromHash(hash)));
        return mav;
    }
}
