package com.vektorel.kutuphane.entity;

import com.vektorel.kutuphane.entity.enums.Role;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Auth extends BaseEntity {
    private String email;
    private String password;
    private String username;
    private Role role;
}
