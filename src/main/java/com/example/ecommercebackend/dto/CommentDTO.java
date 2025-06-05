package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    @NotBlank(message = "Content is required")
    private String content;

    @Min(value = 1, message = "Score must be greater than 0")
    @Max(value = 5, message = "Score must be less than 6")
    private Integer score;

    private Long userId;
}
