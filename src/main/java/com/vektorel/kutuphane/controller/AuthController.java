package com.vektorel.kutuphane.controller;

import com.vektorel.kutuphane.dto.request.AuthSaveRQ;
import com.vektorel.kutuphane.entity.enums.Role;
import com.vektorel.kutuphane.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("save")
    public void saveAuth(@RequestBody AuthSaveRQ dto){
       authService.saveAuth(dto);

    }



}
