package pl.sda.grocefy.product.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ItemEntity;
import pl.sda.grocefy.product.mapper.ItemMapper;
import pl.sda.grocefy.product.mapper.ProductMapper;
import pl.sda.grocefy.product.mapper.ShoppingListMapper;
import pl.sda.grocefy.product.repository.ItemRepository;
import pl.sda.grocefy.product.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ItemMapper itemMapper;
    private final ShoppingListMapper shoppingListMapper;
    private final ProductMapper productMapper;

    public ItemServiceImpl(ItemRepository repository, ItemMapper itemMapper, ShoppingListMapper shoppingListMapper, ProductMapper productMapper) {
        this.repository = repository;
        this.itemMapper = itemMapper;
        this.shoppingListMapper = shoppingListMapper;
        this.productMapper = productMapper;
    }


    @Override
    public List<ItemDTO> findItemsFromList(ShoppingListDTO list) {
        List<ItemEntity> allByList = repository.findAllByList(shoppingListMapper.mapToEntity(list));
        return allByList.stream().map(itemMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO findItemByProduct(ProductDTO productDTO) {
        ItemEntity byProduct = repository.findByProduct(productMapper.mapToEntity(productDTO));
        return itemMapper.mapToDTO(byProduct);
    }

    @Override
    public void addItem(ItemDTO newItem) {
        repository.save(itemMapper.mapToEntity(newItem));
    }

    @Override
    public List<ItemDTO> findItemsByListId(Long id) {
        List<ItemEntity> byListId = repository.findByList_Id(id);
        return byListId.stream().map(itemMapper::mapToDTO).collect(Collectors.toList());
    }
}
