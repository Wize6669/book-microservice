package com.relatos.papel.books.controller;

import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;
import com.relatos.papel.books.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<BookResponse> findByCategory(@PathVariable Long categoryId) {
        return bookService.findAllByCategoryId(categoryId);
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@Valid @RequestBody CreateBookRequest request) {
        BookResponse bookResponse = bookService.save(request);
        return ResponseEntity.created(URI.create("/api/v1/books/" + bookResponse.getId())).body(bookResponse);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody CreateBookRequest request) {
        return bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
