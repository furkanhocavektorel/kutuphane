package com.vektorel.kutuphane.exception.custom;

import com.vektorel.kutuphane.exception.AllException;

public class CustomerException extends RuntimeException{
    public AllException exp;
    public CustomerException() {
    }

    public CustomerException(AllException exp) {
        super(exp.getMessage());
        this.exp=exp;
    }
}
