package pl.sda.grocefy.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private ShoppingList list;

    @OneToMany(mappedBy = "id")
    private List<Product> productList;
    private int count;
    private Unit unit;

}
