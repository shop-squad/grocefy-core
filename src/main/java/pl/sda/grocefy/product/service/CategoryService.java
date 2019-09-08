package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    void addCategory(CategoryDTO categoryDTO);
}
