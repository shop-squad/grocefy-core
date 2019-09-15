package pl.sda.grocefy.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product;
    private String hash;
    //    @OneToOne(cascade = CascadeType.ALL)
    //    private ProductEntity product;
    private int count;
    @Enumerated(EnumType.STRING)
    private Unit unit;

}
