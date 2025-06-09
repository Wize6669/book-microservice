package com.relatos.papel.books.utils;

import com.relatos.papel.books.model.criteria.BookCriteria;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class FilterUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static BookCriteria parseFilters(MultiValueMap<String, String> params) {
        BookCriteria.BookCriteriaBuilder criteriaBuilder = BookCriteria.builder();

        Map<String, String> filters = params.toSingleValueMap();

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value == null || value.isEmpty()) {
                continue;
            }

            try {
                switch (key) {
                    case "id":
                        criteriaBuilder.id(Long.parseLong(value));
                        break;
                    case "title":
                        criteriaBuilder.title(value);
                        break;
                    case "author":
                        criteriaBuilder.author(value);
                        break;
                    case "isbn":
                        criteriaBuilder.isbn(value);
                        break;
                    case "publishedDateFrom":
                        criteriaBuilder.publishedDateFrom(DATE_FORMAT.parse(value));
                        break;
                    case "publishedDateTo":
                        criteriaBuilder.publishedDateTo(DATE_FORMAT.parse(value));
                        break;
                    case "ratingFrom":
                        criteriaBuilder.ratingFrom(Double.parseDouble(value));
                        break;
                    case "ratingTo":
                        criteriaBuilder.ratingTo(Double.parseDouble(value));
                        break;
                    case "priceFrom":
                        criteriaBuilder.priceFrom(new BigDecimal(value));
                        break;
                    case "priceTo":
                        criteriaBuilder.priceTo(new BigDecimal(value));
                        break;
                    case "discountFrom":
                        criteriaBuilder.discountFrom(Integer.parseInt(value));
                        break;
                    case "discountTo":
                        criteriaBuilder.discountTo(Integer.parseInt(value));
                        break;
                    case "status":
                        criteriaBuilder.status(Boolean.parseBoolean(value));
                        break;
                    case "categoryId":
                        criteriaBuilder.categoryId(Long.parseLong(value));
                        break;
                    case "categoryName":
                        criteriaBuilder.categoryName(value);
                        break;
                }
            } catch (NumberFormatException | ParseException e) {
                // Log the error or handle invalid format
                System.err.println("Error parsing filter parameter: " + key + " = " + value);
            }
        }

        return criteriaBuilder.build();
    }
}