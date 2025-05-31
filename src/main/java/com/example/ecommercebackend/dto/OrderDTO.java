package com.example.ecommercebackend.dto;

import com.example.ecommercebackend.entity.Order;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String address;
    private String phoneNumber;
    private Order.OrderStatus status;
    private LocalDate createdAt;

    private Long userId;
    private List<OrderItemDTO> orderItems;
}
