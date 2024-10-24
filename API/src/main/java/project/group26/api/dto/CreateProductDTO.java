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
public class CreateProductDTO {
    @NotBlank(message= "Product name is required")
    private  String productName;
    @NotNull(message = "Price is missing")
    @PositiveOrZero(message = "Price must be a positive int")
    private Double price;
    private String description;
}
