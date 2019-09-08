package pl.sda.grocefy.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
