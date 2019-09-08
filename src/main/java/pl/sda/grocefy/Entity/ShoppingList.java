package pl.sda.grocefy.Entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String hash;

    @OneToOne
    private User user;

}
