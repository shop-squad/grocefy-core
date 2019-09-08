package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sda.grocefy.product.entity.Unit;

@Getter
@Builder
public class ItemDTO {

    private ShoppingListDTO list;
    private ProductDTO product;
    private int count;
    private Unit unit;
}
