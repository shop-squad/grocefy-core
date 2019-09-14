package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.ItemEntity;
import pl.sda.grocefy.product.entity.ProductEntity;




public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findByProduct(ProductEntity product);
}
