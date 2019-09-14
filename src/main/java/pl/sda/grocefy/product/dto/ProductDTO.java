package pl.sda.grocefy.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.grocefy.product.entity.CategoryEntity;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private CategoryEntity category;

    public ProductDTO(String name) {
        this.name = name;
    }
}
