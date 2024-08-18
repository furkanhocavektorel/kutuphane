package com.vektorel.kutuphane.exception.custom;

import com.vektorel.kutuphane.exception.AllException;

public class AuthException extends RuntimeException {
    public AllException exp;

    public AuthException() {

    }

    public AuthException(AllException exp) {
        super(exp.getMessage());
        this.exp = exp;
    }
}
