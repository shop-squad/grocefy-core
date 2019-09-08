package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;

@Service
public class ShoppingListMapper {
    private final UserMapper userMapper;

    public ShoppingListMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ShoppingListDTO mapToDTO(ShoppingListEntity shoppingListEntity){
        return ShoppingListDTO.builder()
                .hash(shoppingListEntity.getHash())
                .user(userMapper.mapUser(shoppingListEntity.getUser())).build();
    }

    public ShoppingListEntity mapToEntity(ShoppingListDTO shoppingListDTO){
        return ShoppingListEntity.builder()
                .id(null)
                .hash(shoppingListDTO.getHash())
                .user(userMapper.mapUserToEntity(shoppingListDTO.getUser())).build();
    }
}
