package com.relatos.papel.books.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    BOOK_NOT_FOUND("ERR_BOO_001", "Book not found"),
    INVALID_BOOK("ERR_BOO_002", "Invalid book data"),
    CATEGORY_NOT_FOUND("ERR_CAT_001", "Category not found"),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred"),
    ;


    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}