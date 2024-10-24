package project.group26.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
    @Setter
    @NoArgsConstructor
    public class UpdateProductDTO {
        @NotBlank(message = "Product name is required")
        private String productName;
        @NotNull(message = "Price is required")
        @PositiveOrZero(message = "Price must be a positive number or zero")
        private Double price;
        private String description;
        private boolean active;
        private String thumbnailUrl;
        private String[] images;
}
