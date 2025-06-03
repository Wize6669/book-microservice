package com.relatos.papel.books.service;

import com.relatos.papel.books.mapper.BookMapper;
import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;
import com.relatos.papel.books.repository.BookRepository;
import com.relatos.papel.books.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse findById(Long id) {
        return null;
    }

    @Override
    public List<BookResponse> findAll() {
        return List.of();
    }

    @Override
    public List<BookResponse> findAllByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public List<BookResponse> findAllByStatus(Boolean status) {
        return List.of();
    }

    @Override
    public BookResponse findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public BookResponse save(CreateBookRequest request) {
        return null;
    }

    @Override
    public BookResponse update(Long id, CreateBookRequest request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
