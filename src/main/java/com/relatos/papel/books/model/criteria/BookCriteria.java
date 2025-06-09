package com.relatos.papel.books.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCriteria {
    private Long id;
    private String title;

    private String author;
    private String isbn;
    private Date publishedDateFrom;
    private Date publishedDateTo;
    private Double ratingFrom;
    private Double ratingTo;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Integer discountFrom;
    private Integer discountTo;
    private Boolean status;
    private Long categoryId;
    private String categoryName;
}
