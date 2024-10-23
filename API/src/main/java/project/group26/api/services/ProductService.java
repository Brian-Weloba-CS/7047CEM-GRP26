package project.group26.api.services;

import org.springframework.stereotype.Service;
import project.group26.api.models.Product;
import project.group26.api.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
