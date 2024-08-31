package com.vektorel.kutuphane.entity;

import com.vektorel.kutuphane.entity.enums.BookApprov;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private BookApprov approv;
    private Long adminId;
}
