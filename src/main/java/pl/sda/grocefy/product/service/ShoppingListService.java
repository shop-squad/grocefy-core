package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ShoppingListDTO;

public interface ShoppingListService {
    ShoppingListDTO findListByHash(String hash);
    void addList(ShoppingListDTO shoppingListDTO);
}
