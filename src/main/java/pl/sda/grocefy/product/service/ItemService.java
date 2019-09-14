package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.dto.ShoppingListDTO;

import java.util.List;

public interface ItemService {

    List<ItemDTO> findItemsFromList(ShoppingListDTO list);
    ItemDTO findItemByProduct(ProductDTO productDTO);
    List<ItemDTO> findItemsByListId(Long id);
    void addItem(ItemDTO newItem);

}
