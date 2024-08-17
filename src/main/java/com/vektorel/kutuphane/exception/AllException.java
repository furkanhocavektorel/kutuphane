package com.vektorel.kutuphane.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AllException {


    private String message;
    private int statusCode;
}
