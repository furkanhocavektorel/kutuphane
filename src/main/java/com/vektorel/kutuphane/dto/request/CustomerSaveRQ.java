package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRQ {
    private String name;
    private String surname;
    private Long countryId;
    private Long cityId;
    private String address;
    private Long authId;
}
