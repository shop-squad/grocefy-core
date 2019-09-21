package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.exception.WebApplicationException;

import java.util.List;

public interface ItemService {

    List<ItemDTO> findItemByListHash(String hash);
    void addItem(String hash, ItemDTO newItem);
    void removeItem(ItemDTO itemToRemove);
    void deleteAllItemsByListHash(String hash);

}
