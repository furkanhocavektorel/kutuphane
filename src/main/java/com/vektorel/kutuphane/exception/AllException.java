package com.vektorel.kutuphane.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AllException {


    // Admin exception
    ADMIN_NOT_FOUND(2001,"Id'ye ait Admin Bulunamadı"),

    // Auth exception
    USERNAME_OR_EMAIL_ALREADY_EXISTS(1001,"Username or email already exists!!!");







    private int statusCode;
    private String message;

}
