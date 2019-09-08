package pl.sda.grocefy.product.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private CategoryEntity category;
}
