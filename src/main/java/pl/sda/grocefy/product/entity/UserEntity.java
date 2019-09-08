package pl.sda.grocefy.product.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
}
