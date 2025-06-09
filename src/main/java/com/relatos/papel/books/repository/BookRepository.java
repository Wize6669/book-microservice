package com.relatos.papel.books.repository;

import com.relatos.papel.books.model.entity.Book;
import com.relatos.papel.books.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findAllByCategory(Category category);
}
