package com.vektorel.kutuphane.entity;

import com.vektorel.kutuphane.entity.enums.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Admin extends BaseEntity {

    private String name;
    private String surname;
    private String birthDate;
    private Gender gender;
    private String securityQuestion;
    private String securityAnswer;
}
