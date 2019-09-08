package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.ShoppingListEntity;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {
    ShoppingListEntity findByHash(String hash);
}
