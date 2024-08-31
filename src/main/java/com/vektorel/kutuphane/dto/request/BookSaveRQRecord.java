package com.vektorel.kutuphane.dto.request;

// record dto
public record BookSaveRQRecord(
        String name,
        int pageCount,
        String publisher,
        int version,
        String ISBN,
        int stock,
        String token) {}
