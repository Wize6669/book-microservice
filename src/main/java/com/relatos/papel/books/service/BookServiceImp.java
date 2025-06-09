package com.relatos.papel.books.service;

import com.relatos.papel.books.exceptions.book.BookNotFoundException;
import com.relatos.papel.books.exceptions.category.CategoryNotFoundException;
import com.relatos.papel.books.mapper.BookMapper;
import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.dto.CreateBookRequest;
import com.relatos.papel.books.model.entity.Book;
import com.relatos.papel.books.model.entity.Category;
import com.relatos.papel.books.repository.BookRepository;
import com.relatos.papel.books.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse findById(Long id) {
        return bookRepository
                .findById(id)
                .map(bookMapper::toBookResponse)
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<BookResponse> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toBookResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findAllByCategoryId(Long categoryId) {
        return categoryRepository
                .findById(categoryId)
                .map(bookRepository::findAllByCategory)
                .map(books -> books.stream()
                        .map(bookMapper::toBookResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);
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
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setDescription(request.getDescription());
        book.setRating(request.getRating());
        book.setPublishedDate(request.getPublishedDate());
        book.setPrice(request.getPrice());
        book.setDiscount(request.getDiscount() != null ? request.getDiscount() : 0);
        book.setImage(request.getImage());
        book.setStatus(true);
        book.setCategory(category);

        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookResponse(savedBook);
    }

    @Override
    public BookResponse update(Long id, CreateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setDescription(request.getDescription());
        book.setRating(request.getRating());
        book.setPublishedDate(request.getPublishedDate());
        book.setPrice(request.getPrice());
        book.setDiscount(request.getDiscount() != null ? request.getDiscount() : 0);
        book.setImage(request.getImage());
        book.setStatus(request.getStatus() != null ? request.getStatus() : true);
        book.setCategory(category);

        Book updatedBook = bookRepository.save(book);
        return bookMapper.toBookResponse(updatedBook);
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        bookRepository.delete(book);
    }
}
