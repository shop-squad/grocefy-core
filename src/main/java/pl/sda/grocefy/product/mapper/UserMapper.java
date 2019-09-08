package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.UserEntity;
@Component
public class UserMapper {

    public UserDTO mapUser(UserEntity userEntity) {
        return UserDTO.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail()).build();
    }

    public UserEntity mapUserToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .id(null)
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail()).build();
    }
}
