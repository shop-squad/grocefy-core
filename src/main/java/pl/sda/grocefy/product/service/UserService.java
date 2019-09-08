package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.UserDTO;

public interface UserService {

    UserDTO findUser(String username);
    void addUser(UserDTO newUser);
}
