package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.Unit;
import pl.sda.grocefy.product.service.ItemService;
import pl.sda.grocefy.product.service.ProductService;
import pl.sda.grocefy.product.service.ShoppingListService;

import java.util.UUID;

@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final ItemService itemService;
    private final ProductService productService;

    public ShoppingListController(ShoppingListService shoppingListService, ItemService itemService, ProductService productService) {
        this.shoppingListService = shoppingListService;
        this.itemService = itemService;
        this.productService = productService;
    }


    @RequestMapping("/")
    public ModelAndView getForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newList", new ShoppingListDTO());
        modelAndView.addObject("lists", shoppingListService.getAll());
        return modelAndView;
    }

    @PostMapping("list/new")
    public ModelAndView newList(@ModelAttribute("newList") ShoppingListDTO newList) {
        newList.setHash(UUID.randomUUID().toString());
        shoppingListService.addList(newList);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/list/{hash}")
    public ModelAndView showList(@PathVariable("hash") String hash) {
        ModelAndView mav = new ModelAndView("showList");
        mav.addObject("list", shoppingListService.findListByHash(hash));
        mav.addObject("items", itemService.findItemsByListId(shoppingListService.getListIdFromHash(hash)));
        return mav;
    }

    @RequestMapping("/list/edit/{hash}")
    public ModelAndView editList(@PathVariable("hash") String hash) {
        ModelAndView mav = new ModelAndView("editList");
        mav.addObject("list", shoppingListService.findListByHash(hash));
        mav.addObject("items", itemService.findItemsByListId(shoppingListService.getListIdFromHash(hash)));
        mav.addObject("units", Unit.values());
        mav.addObject("newItem", new ItemDTO());
        return mav;
    }

    @PostMapping("/list/edit/{hash}")
    public void addItemToList(@PathVariable("hash") String hash, @ModelAttribute("newItem") ItemDTO newItem){
        newItem.setList(shoppingListService.findListByHash(hash));
        String name = newItem.getProduct().getName();
        ProductDTO productByName = productService.getProductByName(name);
        newItem.setProduct(productByName);
        itemService.addItem(newItem);
    }
}
