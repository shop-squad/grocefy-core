package pl.sda.grocefy.Entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Category category;
}
