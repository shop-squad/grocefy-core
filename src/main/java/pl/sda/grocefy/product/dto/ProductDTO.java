package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sda.grocefy.product.entity.CategoryEntity;


@Getter
@Builder
public class ProductDTO {

    private String name;
    private CategoryEntity category;
}
