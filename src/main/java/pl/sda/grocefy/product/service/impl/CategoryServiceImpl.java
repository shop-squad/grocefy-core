package pl.sda.grocefy.product.service.impl;

import pl.sda.grocefy.product.dto.CategoryDTO;
import pl.sda.grocefy.product.mapper.CategoryMapper;
import pl.sda.grocefy.product.repository.CategoryRepository;
import pl.sda.grocefy.product.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        repository.save(mapper.mapToEntity(categoryDTO));
    }
}
