package com.relatos.papel.books.service;

import com.relatos.papel.books.model.criteria.BookCriteria;
import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;

import java.util.List;
import java.util.Map;

public interface BookService {
    BookResponse findById(Long id);

    List<BookResponse> findAll();

    List<BookResponse> findAllByCategoryId(Long categoryId);

    List<BookResponse> findByCriteria(BookCriteria criteria);

    BookResponse save(CreateBookRequest request);

    BookResponse update(Long id, CreateBookRequest request);

    void deleteById(Long id);
}
