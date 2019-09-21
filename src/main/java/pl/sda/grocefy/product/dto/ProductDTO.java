package pl.sda.grocefy.product.dto;

import lombok.*;
import pl.sda.grocefy.product.entity.CategoryEntity;


@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private CategoryEntity category;

    public ProductDTO(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
