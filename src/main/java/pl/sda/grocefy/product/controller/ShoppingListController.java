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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        newList.setItems(new ArrayList<>());
        shoppingListService.addList(newList);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/list/{hash}")
    public ModelAndView showList(@PathVariable("hash") String hash) {
        ModelAndView mav = new ModelAndView("showList");
        mav.addObject("list", shoppingListService.findListByHash(hash));
        mav.addObject("items", itemService.findItemByListHash(hash));
        return mav;
    }

    @RequestMapping(value = "/list/edit/{hash}")
    public ModelAndView editList(@PathVariable("hash") String hash) {
        ModelAndView mav = new ModelAndView("editList");
        mav.addObject("list", shoppingListService.findListByHash(hash));
        mav.addObject("items", itemService.findItemByListHash(hash));
        mav.addObject("units", Unit.values());
        mav.addObject("newItem", new ItemDTO());
        return mav;
    }

    @PostMapping("/list/edit/{hash}")
    public ModelAndView addItemToList(@PathVariable("hash") String hash, @ModelAttribute("newItem") ItemDTO newItem) {
        List<ItemDTO> itemsList = itemService.findItemByListHash(hash);
        Optional<ItemDTO> first = itemsList.stream().filter(itemDTO -> itemDTO.getProduct().equalsIgnoreCase(newItem.getProduct())).findFirst();
        if (first.isPresent()) {
            ItemDTO itemDTO = first.get();
            itemService.removeItem(itemDTO);
            itemDTO.setCount(itemDTO.getCount() + newItem.getCount());
            itemService.addItem(hash, itemDTO);
        } else {
            itemService.addItem(hash, newItem);
        }
        return new ModelAndView("redirect:/list/edit/" + hash);
    }
}
