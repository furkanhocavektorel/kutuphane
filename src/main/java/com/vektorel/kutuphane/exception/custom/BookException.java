package com.vektorel.kutuphane.exception.custom;

import com.vektorel.kutuphane.exception.AllException;

public class BookException extends RuntimeException{
    public AllException exp;

    public BookException() {

    }

    public BookException(AllException exp) {
        super(exp.getMessage());
        this.exp = exp;
    }
}
