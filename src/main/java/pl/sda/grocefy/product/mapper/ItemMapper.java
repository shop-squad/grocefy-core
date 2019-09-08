package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.entity.ItemEntity;
@Component
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
                .product(productMapper.mapToDTO(itemEntity.getProduct()))
                .build();
    }

    public ItemEntity mapToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(null)
                .count(itemDTO.getCount())
                .list(shoppingListMapper.mapToEntity(itemDTO.getList()))
                .product(productMapper.mapToEntity(itemDTO.getProduct()))
                .unit(itemDTO.getUnit())
                .build();
    }
}
