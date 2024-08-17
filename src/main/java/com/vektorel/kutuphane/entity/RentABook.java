package com.vektorel.kutuphane.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class RentABook extends BaseEntity{

    private Long customerId;
    private Long bookId;
    private String rentDate;
    private int rentalPeriod; // kiralama süresi
}
