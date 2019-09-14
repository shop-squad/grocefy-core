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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ItemMapper itemMapper;
    private final ProductMapper productMapper;

    public ItemServiceImpl(ItemRepository repository, ItemMapper itemMapper, ProductMapper productMapper) {
        this.repository = repository;
        this.itemMapper = itemMapper;
        this.productMapper = productMapper;
    }


    @Override
    public ItemDTO findItemByProduct(ProductDTO productDTO) {
        ItemEntity byProduct = repository.findByProduct(productMapper.mapToEntity(productDTO));
        return itemMapper.mapToDTO(byProduct);
    }

    @Override
    public void addItem(String hash, ItemDTO newItem) {


        repository.save(itemMapper.mapToEntity(newItem));
    }

    @Override
    public List<ItemDTO> findItemsByListId(Long id) {
        return new ArrayList<>();
    }
}
