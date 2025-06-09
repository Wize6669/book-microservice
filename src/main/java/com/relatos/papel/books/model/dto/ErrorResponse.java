package com.relatos.papel.books.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
// Controller advice response for errors
public class ErrorResponse {
    private String code;
    private HttpStatus status;
    private String message;
    private List<String> detailMessages;
    private LocalDateTime timestamp;
}
