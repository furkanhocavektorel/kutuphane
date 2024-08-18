package com.vektorel.kutuphane.exception;

import com.vektorel.kutuphane.exception.custom.AdminException;
import com.vektorel.kutuphane.exception.custom.AuthException;
import com.vektorel.kutuphane.exception.custom.TokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminException.class)
    @ResponseBody
    public ErrorMessage AdminExceptionHandler(AdminException exception){
        return createError(exception.exp);
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public ErrorMessage AuthExceptionHandler(AuthException exception){
        return createError(exception.exp);
    }

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public ErrorMessage TokenExceptionHandler(TokenException exception){
        return createError(exception.exp);
    }


    public ErrorMessage createError(AllException allException){
        return ErrorMessage.builder()
                .statusCode(allException.getStatusCode())
                .message(allException.getMessage())
                .build();
    }


}
