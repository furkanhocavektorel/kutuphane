package com.vektorel.kutuphane.entity;

import com.vektorel.kutuphane.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_auth")
public class Auth extends BaseEntity {
    private String email;
    private String password;
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
}
