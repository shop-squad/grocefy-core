package pl.sda.grocefy.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ShoppingListEntity list;

    @OneToOne(cascade=CascadeType.ALL)
    private ProductEntity product;
    private int count;
    @Enumerated(EnumType.STRING)
    private Unit unit;

}
