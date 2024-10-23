package project.group26.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.group26.api.models.Product;
import project.group26.api.services.ProductService;

import java.util.List;

@RestController("/products")
public class ProductController {

    private  final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
