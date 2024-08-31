package com.vektorel.kutuphane.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String name;
    private int pageCount;
    private String publisher;
    private int stock;
}
