package com.vektorel.kutuphane.controller;

import com.vektorel.kutuphane.dto.request.LoginRQ;
import com.vektorel.kutuphane.dto.request.RegisterRQ;
import com.vektorel.kutuphane.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    public void register(@RequestBody RegisterRQ dto){
       authService.register(dto);
    }

    @PostMapping("login")
    public String login (@RequestBody LoginRQ dto){
        return authService.login(dto);
    }

}
