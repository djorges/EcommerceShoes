package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;


@Data
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @Positive(message = "Cannot be negative")
    private Double price;
    @PositiveOrZero(message = "Cannot be negative")
    private Integer quantity;
    private String image;

    private List<CommentDTO> commentDTOList;
}
