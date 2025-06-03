package com.relatos.papel.books.service;

import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;

import java.util.List;

public interface BookService {
    BookResponse findById(Long id);

    List<BookResponse> findAll();

    List<BookResponse> findAllByCategoryId(Long categoryId);

    List<BookResponse> findAllByStatus(Boolean status);

    BookResponse findBookByIsbn(String isbn);

    BookResponse save(CreateBookRequest request);

    BookResponse update(Long id, CreateBookRequest request);

    void deleteById(Long id);
}
