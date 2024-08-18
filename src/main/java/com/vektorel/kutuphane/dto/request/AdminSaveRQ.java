package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminSaveRQ {

    private String name;
    private String surname;
    private String securityQuestion;
    private String securityAnswer;
}
