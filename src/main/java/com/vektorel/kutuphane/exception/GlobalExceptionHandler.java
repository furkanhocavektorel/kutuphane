package com.vektorel.kutuphane.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {





    public ErrorMessage createError(AllException allException){
        return ErrorMessage.builder()
                .statusCode(allException.getStatusCode())
                .message(allException.getMessage())
                .build();
    }


}
