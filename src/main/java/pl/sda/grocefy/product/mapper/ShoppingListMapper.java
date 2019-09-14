package pl.sda.grocefy.product.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;

import java.util.stream.Collectors;

@Component
public class ShoppingListMapper {
    private final UserMapper userMapper;
    private final ItemMapper itemMapper;

    public ShoppingListMapper(UserMapper userMapper, ItemMapper itemMapper) {
        this.userMapper = userMapper;
        this.itemMapper = itemMapper;
    }

    public ShoppingListDTO mapToDTO(ShoppingListEntity shoppingListEntity){
        return ShoppingListDTO.builder()
                .name(shoppingListEntity.getName())
                .hash(shoppingListEntity.getHash())
                .items(shoppingListEntity.getItems().stream().map(itemMapper::mapToDTO).collect(Collectors.toList()))
                .user(null).build();
    }

    public ShoppingListEntity mapToEntity(ShoppingListDTO shoppingListDTO){
        return ShoppingListEntity.builder()
                .id(null)
                .items(shoppingListDTO.getItems().stream().map(itemMapper::mapToEntity).collect(Collectors.toList()))
                .name(shoppingListDTO.getName())
                .hash(shoppingListDTO.getHash())
                .user(null).build();
    }
}
