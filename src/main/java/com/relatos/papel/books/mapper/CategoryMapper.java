package com.relatos.papel.books.mapper;

import com.relatos.papel.books.model.dto.CategoryResponse;
import com.relatos.papel.books.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);
}
