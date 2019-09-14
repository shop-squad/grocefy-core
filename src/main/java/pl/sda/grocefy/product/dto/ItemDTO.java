package pl.sda.grocefy.product.dto;

import lombok.*;
import pl.sda.grocefy.product.entity.Unit;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ItemDTO {

    private ShoppingListDTO list;
    private ProductDTO product;
    private int count;
    private Unit unit;

    public ItemDTO() {
        this.list = new ShoppingListDTO(null,UUID.randomUUID().toString(), new UserDTO("jan", "hasło", "sdfgsd@dfsf"));
        this.product = new ProductDTO();
    }
}
