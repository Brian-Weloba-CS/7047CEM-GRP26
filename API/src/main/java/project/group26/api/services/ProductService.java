package project.group26.api.services;

import org.springframework.stereotype.Service;
import project.group26.api.dto.CreateProductDTO;
import project.group26.api.dto.UpdateProductDTO;
import project.group26.api.models.Product;
import project.group26.api.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductById(String idString) {
        try {
            Long id = Long.parseLong(idString);
            return productRepository.findById(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid id format: " + idString + ". Please provide a valid numeric id.");
        }
    }

    public Product addProduct( CreateProductDTO productDTO) {
            Product product = new Product();
            product.setName(productDTO.getProductName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());

            return productRepository.save(product);


    }

    public Product updateProduct(String productId, UpdateProductDTO productDTO) {
        Optional<Product> productOptional = getProductById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Update fields from DTO
            product.setName(productDTO.getProductName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setThumbnailUrl(productDTO.getThumbnailUrl());
            product.setImages(productDTO.getImages());

            // Save and return the updated product
            return productRepository.save(product);
        } else {
            throw new NullPointerException("Product not found with ID: " + productId);
        }
    }

    public String deleteById(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product Id cannot be null or empty.");
        }

        Long id;
        try {
            id = Long.parseLong(productId);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "Invalid id format: " + productId + ". Please provide a valid numeric id.");
        }

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return "Product with id " + productId + " deleted successfully.";
        } else {
            throw new NullPointerException("Product with id " + id + " does not exist.");
        }

    }
}
