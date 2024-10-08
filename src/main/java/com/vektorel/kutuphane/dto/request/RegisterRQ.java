package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRQ {
    private String name;
    private String surname;
    private String mailAddress;
    private String password;
    private String username;
    private String birthDate;
    private String role;
    private String securityQuestion;
    private String securityAnswer;
    private Long countryId;
    private Long cityId;
    private String address;

}
