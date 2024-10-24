package project.group26.api.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private String image;
    private String SKU;
}
