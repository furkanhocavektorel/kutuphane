package com.vektorel.kutuphane.exception.custom;

import com.vektorel.kutuphane.exception.AllException;

public class AdminException extends RuntimeException{

    public AllException exp;

    public AdminException() {
    }

    public AdminException(AllException exp) {
        super(exp.getMessage());
        this.exp = exp;
    }
}
