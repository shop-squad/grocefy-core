package pl.sda.grocefy.product.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.CategoryDTO;
import pl.sda.grocefy.product.entity.CategoryEntity;
@Service
public class CategoryMapper {

    public CategoryDTO mapToDTO(CategoryEntity categoryEntity){
        return CategoryDTO.builder()
                .name(categoryEntity.getName()).build();
    }

    public CategoryEntity mapToEntity(CategoryDTO categoryDTO){
        return CategoryEntity.builder()
                .id(null)
                .name(categoryDTO.getName()).build();
    }

}
