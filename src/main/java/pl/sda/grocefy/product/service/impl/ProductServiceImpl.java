package pl.sda.grocefy.product.service.impl;

import pl.sda.grocefy.product.dto.ProductDTO;
import pl.sda.grocefy.product.entity.ProductEntity;
import pl.sda.grocefy.product.mapper.ProductMapper;
import pl.sda.grocefy.product.repository.ProductRepository;
import pl.sda.grocefy.product.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO getProductByName(String name) {
        return mapper.mapToDTO(repository.findByName(name));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> allProducts = repository.findAll();
        return allProducts.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addProduct(ProductDTO newProduct) {
        repository.save(mapper.mapToEntity(newProduct));
    }
}
