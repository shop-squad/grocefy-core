package pl.sda.grocefy.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(mappedBy = "id")
    private ProductEntity product;
    private int count;
    @Enumerated(EnumType.STRING)
    private Unit unit;

}
