package pl.sda.grocefy.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.grocefy.product.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
