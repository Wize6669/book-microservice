package com.relatos.papel.books.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Date publishedDate;

    private String description;

    private Double rating;

    private BigDecimal price;

    private String image;

    private Integer discount;

    private String status;

    private CategoryResponse category;
}
