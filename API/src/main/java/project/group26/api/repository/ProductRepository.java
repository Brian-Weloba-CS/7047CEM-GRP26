package project.group26.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.group26.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
