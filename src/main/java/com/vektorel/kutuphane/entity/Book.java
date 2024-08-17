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
public class Book extends BaseEntity {

    private String name;
    private int pageCount;
    private String publisher;
    private int version;
    private int volumeNumber;
    private int ISBN;
    private int stock;

}
