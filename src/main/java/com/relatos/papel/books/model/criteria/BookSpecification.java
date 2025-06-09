package com.relatos.papel.books.model.criteria;

import com.relatos.papel.books.model.entity.Book;
import com.relatos.papel.books.model.entity.Category;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookSpecification {

    public static Specification<Book> filterByCriteria(BookCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), criteria.getId()));
            }

            if (criteria.getTitle() != null && !criteria.getTitle().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("title")),
                        "%" + criteria.getTitle().toLowerCase() + "%"
                ));
            }

            if (criteria.getAuthor() != null && !criteria.getAuthor().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("author")),
                        "%" + criteria.getAuthor().toLowerCase() + "%"
                ));
            }

            if (criteria.getIsbn() != null && !criteria.getIsbn().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("isbn"), criteria.getIsbn()));
            }

            if (criteria.getPublishedDateFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("publishedDate"), criteria.getPublishedDateFrom()
                ));
            }

            if (criteria.getPublishedDateTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("publishedDate"), criteria.getPublishedDateTo()
                ));
            }

            if (criteria.getRatingFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("rating"), criteria.getRatingFrom()
                ));
            }

            if (criteria.getRatingTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("rating"), criteria.getRatingTo()
                ));
            }

            if (criteria.getPriceFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("price"), criteria.getPriceFrom()
                ));
            }

            if (criteria.getPriceTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("price"), criteria.getPriceTo()
                ));
            }

            if (criteria.getDiscountFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("discount"), criteria.getDiscountFrom()
                ));
            }

            if (criteria.getDiscountTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("discount"), criteria.getDiscountTo()
                ));
            }

            if (criteria.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
            }

            if (criteria.getCategoryId() != null) {
                Join<Book, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), criteria.getCategoryId()));
            }

            if (criteria.getCategoryName() != null && !criteria.getCategoryName().isEmpty()) {
                Join<Book, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(categoryJoin.get("name")),
                        "%" + criteria.getCategoryName().toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

