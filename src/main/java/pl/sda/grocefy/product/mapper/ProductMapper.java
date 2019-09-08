package pl.sda.grocefy.product.mapper;

import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.entity.ProductEntity;

public class ProductMapper {

    public ProductDTO mapToDTO(ProductEntity productEntity){
        return ProductDTO.builder()
                .name(productEntity.getName())
                .category(productEntity.getCategory()).build();
    }
    public ProductEntity mapToEntity(ProductDTO productDTO){
        return ProductEntity.builder()
                .id(null)
                .name(productDTO.getName())
                .category(productDTO.getCategory()).build();
    }
}
