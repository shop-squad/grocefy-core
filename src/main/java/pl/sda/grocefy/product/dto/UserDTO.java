package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDTO {
    private String username;
    private String password;
    private String email;

    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
