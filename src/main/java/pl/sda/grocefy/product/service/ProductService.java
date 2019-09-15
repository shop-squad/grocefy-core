package pl.sda.grocefy.product.service;

import org.springframework.validation.BindingResult;
import pl.sda.grocefy.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductByName(String name);
    List<ProductDTO> getAllProducts();
    void addProduct(ProductDTO newProduct);
}
