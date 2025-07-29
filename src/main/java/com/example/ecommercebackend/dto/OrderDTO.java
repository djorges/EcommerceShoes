package com.example.ecommercebackend.dto;

import com.example.ecommercebackend.entity.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;

    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private Order.OrderStatus status;
    private LocalDate createdAt;

    private Long userId;

    private List<OrderItemDTO> orderItems;
}
