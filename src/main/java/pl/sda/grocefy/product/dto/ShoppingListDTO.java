package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sda.grocefy.product.entity.UserEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Builder
public class ShoppingListDTO {
    private String hash;
    private UserDTO user;

}
