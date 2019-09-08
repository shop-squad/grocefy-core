package pl.sda.grocefy.product.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sda.grocefy.product.entity.Unit;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ItemDTO {

    private ShoppingListDTO list;
    private List<ProductDTO> productList;
    private int count;
    private Unit unit;
}
