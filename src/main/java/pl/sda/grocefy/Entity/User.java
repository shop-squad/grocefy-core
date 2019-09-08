package pl.sda.grocefy.Entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
}
