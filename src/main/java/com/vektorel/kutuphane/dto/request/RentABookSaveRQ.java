package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentABookSaveRQ {
    private String token;
    private Long bookId;
    private int rentalPeriod;
}
