package com.vektorel.kutuphane.exception.custom;

import com.vektorel.kutuphane.exception.AllException;

public class TokenException extends RuntimeException{
    public AllException exp;

    public TokenException() {
    }

    public TokenException(AllException exp) {
        super(exp.getMessage());
        this.exp = exp;
    }
}
