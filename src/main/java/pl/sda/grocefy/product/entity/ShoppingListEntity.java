package pl.sda.grocefy.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "shopping_list")
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String hash;

    @OneToOne
    private UserEntity user;

    @OneToMany
    private List<ItemEntity> items;

}
