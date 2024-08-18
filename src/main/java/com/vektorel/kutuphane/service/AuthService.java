package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.LoginRQ;
import com.vektorel.kutuphane.dto.request.RegisterRQ;
import com.vektorel.kutuphane.entity.Auth;
import com.vektorel.kutuphane.entity.enums.Role;
import com.vektorel.kutuphane.exception.AllException;
import com.vektorel.kutuphane.exception.custom.AuthException;
import com.vektorel.kutuphane.exception.custom.TokenException;
import com.vektorel.kutuphane.mapper.IAdminMapper;
import com.vektorel.kutuphane.mapper.IAuthMapper;
import com.vektorel.kutuphane.mapper.ICustomerMapper;
import com.vektorel.kutuphane.repository.IAuthRepository;
import com.vektorel.kutuphane.util.JwtManager;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    private final AdminService adminService;
    private final CustomerService customerService;

    private final JwtManager jwtManager;

    public AuthService(IAuthRepository repository, AdminService adminService, CustomerService customerService, JwtManager jwtManager) {
        super(repository);
        this.adminService=adminService;
        this.repository = repository;
        this.customerService = customerService;
        this.jwtManager = jwtManager;
    }
    // 2 farklı yöntem var.
    // 1. yöntem
    // bir service metotu içinden dto'dan gelen role bakarak
    // gerekli olan (admin kaydetme / customer kaydetme) metotlarına yönlendirilmeli.

    // TODO saveAuth metodu test edilecek !!!!
    public void register(RegisterRQ dto){

        if (repository.existsByEmailOrUsername(dto.getMailAddress(), dto.getUsername())){
            throw new AuthException(AllException.USERNAME_OR_EMAIL_ALREADY_EXISTS);
        }

        Auth auth=save(IAuthMapper.INSTANCE.toAuth(dto));

        if (auth.getRole()== Role.ADMIN || auth.getRole()== Role.SUPERADMIN){
            adminService.saveAdmin(IAdminMapper.INSTANCE.toDto(dto), auth.getId());

        }else if (auth.getRole()== Role.CUSTOMER){
            customerService.saveCustomer(ICustomerMapper.INSTANCE.toDto(dto), auth.getId());
        }


    }

    // 2.yöntem
/*    public void saveCustomer(){

    }

    public void saveAdmin(){

    }*/


    public String login(LoginRQ dto){
        Auth auth= repository.findOptionalByEmailOrUsername(dto.getEmail(), dto.getUsername()).orElseThrow(()-> new AuthException(AllException.USERNAME_OR_EMAIL_NOT_FOUND));
        if (!auth.getPassword().equals(dto.getPassword())){
            throw new AuthException(AllException.WRONG_PASSWORD);
        }
        return jwtManager.generateToken(auth.getId()).orElseThrow(()-> new TokenException(AllException.TOKEN_CREATE_ERROR));
    }



}
