package com.relatos.papel.books.model.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
public class CreateBookRequest {

    @NotEmpty(message = "The field 'title' cannot be empty or null")
    private String title;

    @NotEmpty(message = "The field 'author' cannot be empty or null")
    private String author;

    @NotEmpty(message = "The field 'isbn' cannot be empty or null")
    private String isbn;

    @PastOrPresent(message = "The published date cannot be in the future")
    private Date publishedDate;

    @Size(max = 1000, message = "The description cannot exceed 1000 characters")
    private String description;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be a positive number")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be less than or equal to 5")
    private Double rating;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    private String image;

    @Min(value = 0, message = "Discount cannot be negative")
    @Max(value = 100, message = "Discount cannot exceed 100")
    private Integer discount;

    @NotNull(message = "Category ID is required")
    private Long categoryId;
}
