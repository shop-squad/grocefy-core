package pl.sda.grocefy.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListDTO {
    private String name;
    private String hash;
    private UserDTO user;

}
