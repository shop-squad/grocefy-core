package pl.sda.grocefy.product.mapper;

import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
@Component
public class ShoppingListMapper {
    private final UserMapper userMapper;

    public ShoppingListMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ShoppingListDTO mapToDTO(ShoppingListEntity shoppingListEntity){
        return ShoppingListDTO.builder()
                .name(shoppingListEntity.getName())
                .hash(shoppingListEntity.getHash())
                .user(null).build();
    }

    public ShoppingListEntity mapToEntity(ShoppingListDTO shoppingListDTO){
        return ShoppingListEntity.builder()
                .id(null)
                .name(shoppingListDTO.getName())
                .hash(shoppingListDTO.getHash())
                .user(null).build();
    }
}
