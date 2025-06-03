package com.relatos.papel.books.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    @Column(name = "published_date")
    private Date publishedDate;
    private String description;
    private Double rating;
    private BigDecimal price;
    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer discount = 0;
    private String image;
    @Column(columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
