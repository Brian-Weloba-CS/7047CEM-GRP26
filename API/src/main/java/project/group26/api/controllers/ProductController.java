package project.group26.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.group26.api.dto.CreateProductDTO;
import project.group26.api.dto.UpdateProductDTO;
import project.group26.api.models.Product;
import project.group26.api.services.ProductService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Optional<Product> productOptional = productService.getProductById(id);

        return productOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(
            @RequestBody @Valid CreateProductDTO createProductDTO) {
        Product product = productService.addProduct(createProductDTO);
        return ResponseEntity.created(URI.create("/api/v1/products/" + product.getId())).body(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id,
                                                 @RequestBody UpdateProductDTO updateProductDTO) {

        Product product = productService.updateProduct(id, updateProductDTO);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(productService.deleteById(id));
    }
}
