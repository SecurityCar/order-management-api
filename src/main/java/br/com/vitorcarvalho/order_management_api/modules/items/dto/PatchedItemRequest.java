package br.com.vitorcarvalho.order_management_api.modules.items.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PatchedItemRequest {
    
    @DecimalMin(value = "0.01", message = "The price has to be greater than zero.")
    private BigDecimal price;

    private String name;
    private String category;
    
    @Positive(message = "The quantity has to be at least one.")
    private Integer quantity;
}
