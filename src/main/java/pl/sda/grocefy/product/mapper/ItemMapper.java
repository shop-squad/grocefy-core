package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.entity.ItemEntity;
@Component
public class ItemMapper {

    public ItemDTO mapToDTO(ItemEntity itemEntity) {
        return ItemDTO.builder()
                .id(itemEntity.getId())
                .hash(itemEntity.getHash())
                .unit(itemEntity.getUnit())
                .count(itemEntity.getCount())
                .product(itemEntity.getProduct())
                .build();
    }

    public ItemEntity mapToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(null)
                .hash(itemDTO.getHash())
                .count(itemDTO.getCount())
                .product(itemDTO.getProduct())
                .unit(itemDTO.getUnit())
                .build();
    }
}
