package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private Long productId;

    @Positive
    private Integer quantity;
}
