package pl.sda.grocefy.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "shopping_list")
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hash = getHashcode();

    @OneToOne
    private UserEntity user;

    private String getHashcode(){
        return  LocalDateTime.now().toString();
    }

}
