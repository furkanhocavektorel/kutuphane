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
public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private String birthDate;
    private Long countryId;
    private Long cityId;
    private String address;
    private Boolean suspended;
    private Long authId;
}
