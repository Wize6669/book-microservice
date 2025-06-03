package com.relatos.papel.books.repository;

import com.relatos.papel.books.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
