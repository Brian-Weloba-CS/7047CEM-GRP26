package project.group26.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Currency;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String category;
    private String image;
    private String SKU;
    private String[] images;
    private String thumbnailUrl;

    @Transient
    @Setter(AccessLevel.NONE)
    String priceValue;
    Currency currency = Currency.getInstance(new Locale("en", "GB"));

    public String getPriceValue() {
        if (this.price != null) {
            return this.currency + this.price.toString();
        } else {
            return this.currency + "0.00";
        }
    }
}
