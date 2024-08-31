package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// standart dto
public class BookSaveRQ {

    private String name;
    private int pageCount;
    private String publisher;
    private int version;
    private String ISBN;
    private int stock;

}
