package pl.sda.grocefy.product.mapper;

import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.entity.ItemEntity;

import java.util.stream.Collectors;

public class ItemMapper {
    private final ShoppingListMapper shoppingListMapper;
    private final ProductMapper productMapper;

    public ItemMapper(ShoppingListMapper shoppingListMapper, ProductMapper productMapper) {
        this.shoppingListMapper = shoppingListMapper;
        this.productMapper = productMapper;
    }

    public ItemDTO mapToDTO(ItemEntity itemEntity) {
        return ItemDTO.builder()
                .list(shoppingListMapper.mapToDTO(itemEntity.getList()))
                .unit(itemEntity.getUnit())
                .count(itemEntity.getCount())
                .productList(itemEntity.getProductList().stream()
                        .map(productMapper::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public ItemEntity mapToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(null)
                .count(itemDTO.getCount())
                .list(shoppingListMapper.mapToEntity(itemDTO.getList()))
                .productList(itemDTO.getProductList().stream()
                        .map(productMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .unit(itemDTO.getUnit())
                .build();
    }
}
