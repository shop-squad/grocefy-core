package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ShoppingListDTO;

import java.util.List;

public interface ShoppingListService {
    ShoppingListDTO findListByHash(String hash);
    List<ShoppingListDTO> getAll();
    void addList(ShoppingListDTO shoppingListDTO);
    void deleteList(String hash);
}
