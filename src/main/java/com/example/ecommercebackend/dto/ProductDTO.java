package com.example.ecommercebackend.dto;

import lombok.Data;

import java.util.List;


@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private List<CommentDTO> commentDTOList;

}
