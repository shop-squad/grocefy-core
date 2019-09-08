package pl.sda.grocefy.product.dto;

import lombok.*;
import pl.sda.grocefy.product.entity.Unit;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private ShoppingListDTO list;
    private ProductDTO product;
    private int count;
    private Unit unit;
}
