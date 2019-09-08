package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sda.grocefy.product.entity.UserEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Builder
public class ShoppingListDTO {
    private String hash;
    private UserDTO user;

    public ShoppingListDTO(String hash, UserDTO user) {
        this.hash = hash;
        this.user = user;
    }
}
