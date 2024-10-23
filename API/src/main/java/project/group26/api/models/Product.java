package project.group26.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private Long Id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private String image;
    private String SKU;
}
