package com.vektorel.kutuphane.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRQ {
    private String email;
    private String username;
    private String password;
}
