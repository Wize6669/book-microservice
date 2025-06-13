package com.relatos.papel.books.controller;

import com.relatos.papel.books.model.criteria.BookCriteria;
import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;
import com.relatos.papel.books.service.BookService;
import com.relatos.papel.books.utils.FilterUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookResponse> findAll(@RequestParam MultiValueMap<String, String> params) {
        if (params.isEmpty() || !hasValidFilters(params)) {
            return bookService.findAll();
        }

        BookCriteria criteria = FilterUtils.parseFilters(params);
        return bookService.findByCriteria(criteria);
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id) {
        return bookService.findById(id);
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

    private boolean hasValidFilters(MultiValueMap<String, String> params) {
        Set<String> validFilterKeys = Set.of(
                "id", "title", "author", "isbn",
                "publishedDateFrom", "publishedDateTo",
                "ratingFrom", "ratingTo",
                "priceFrom", "priceTo",
                "discountFrom", "discountTo",
                "status", "categoryId", "categoryName"
        );

        return params.keySet().stream()
                .anyMatch(validFilterKeys::contains);
    }
}
