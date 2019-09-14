package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.entity.ItemEntity;
@Component
public class ItemMapper {

    private final ProductMapper productMapper;

    public ItemMapper( ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ItemDTO mapToDTO(ItemEntity itemEntity) {
        return ItemDTO.builder()
                .hash(itemEntity.getHash())
                .unit(itemEntity.getUnit())
                .count(itemEntity.getCount())
                .product(productMapper.mapToDTO(itemEntity.getProduct()))
                .build();
    }

    public ItemEntity mapToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(null)
                .hash(itemDTO.getHash())
                .count(itemDTO.getCount())
                .product(productMapper.mapToEntity(itemDTO.getProduct()))
                .unit(itemDTO.getUnit())
                .build();
    }
}
