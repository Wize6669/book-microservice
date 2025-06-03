package com.relatos.papel.books.repository;

import com.relatos.papel.books.model.entity.Book;
import com.relatos.papel.books.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByStatus(Boolean status);

    List<Book> findAllByCategory(Category category);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}
