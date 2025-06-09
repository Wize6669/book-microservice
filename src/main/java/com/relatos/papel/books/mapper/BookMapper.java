package com.relatos.papel.books.mapper;

import com.relatos.papel.books.model.dto.BookResponse;
import com.relatos.papel.books.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.relatos.papel.books.utils.Constants.ACTIVE_STATUS;
import static com.relatos.papel.books.utils.Constants.INACTIVE_STATUS;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface BookMapper {

    @Mapping(target = "status", expression = "java(mapStatus(book))")
    BookResponse toBookResponse(Book book);

    default String mapStatus(Book book) {
        return book.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }
}
