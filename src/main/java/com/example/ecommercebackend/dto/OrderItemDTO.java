package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Long productId;

    @Positive
    private Integer quantity;

    @Positive
    private Double price;
}
