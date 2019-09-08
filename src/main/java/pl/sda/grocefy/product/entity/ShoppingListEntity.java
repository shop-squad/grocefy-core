package pl.sda.grocefy.product.entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String hash;

    @OneToOne
    private UserEntity user;

}
