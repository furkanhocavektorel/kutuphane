package com.vektorel.kutuphane.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentABookRS {
    private Long rentId;
    private String rentDate;
    private int rentalPeriod;
    private Long bookId;
    private String ISBN;
    private String bookName;
    private int stock;
    private int pageCount;
    private String customerName;
    private String customerSurname;
    private Long  customerId;


}
