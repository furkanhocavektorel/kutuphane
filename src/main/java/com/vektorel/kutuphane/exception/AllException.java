package com.vektorel.kutuphane.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AllException {

    //Token exception
    TOKEN_ERROR(3000,"TOKEN ERROR"),
    TOKEN_CREATE_ERROR(3001,"token create error !!!"),

    // Admin exception
    ADMIN_NOT_FOUND(2001,"Id'ye ait Admin Bulunamadı"),

    // Auth exception
    USERNAME_OR_EMAIL_ALREADY_EXISTS(1001,"Username or email already exists!!!"),
    USERNAME_OR_EMAIL_NOT_FOUND(1002,"User Not Found"),
    WRONG_PASSWORD(1003,"Password is wrong");








    private int statusCode;
    private String message;

}
