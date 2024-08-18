package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.AdminSaveRQ;
import com.vektorel.kutuphane.dto.request.AuthSaveRQ;
import com.vektorel.kutuphane.entity.Auth;
import com.vektorel.kutuphane.entity.enums.Role;
import com.vektorel.kutuphane.exception.AllException;
import com.vektorel.kutuphane.exception.custom.AuthException;
import com.vektorel.kutuphane.mapper.IAdminMapper;
import com.vektorel.kutuphane.mapper.IAuthMapper;
import com.vektorel.kutuphane.repository.IAuthRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    private final AdminService adminService;
    private final CustomerService customerService;
    public AuthService(IAuthRepository repository, AdminService adminService, CustomerService customerService) {
        super(repository);
        this.adminService=adminService;
        this.repository = repository;
        this.customerService = customerService;
    }
    // 2 farklı yöntem var.
    // 1. yöntem
    // bir service metotu içinden dto'dan gelen role bakarak
    // gerekli olan (admin kaydetme / customer kaydetme) metotlarına yönlendirilmeli.

    // TODO saveAuth metodu test edilecek !!!!
    public void saveAuth(AuthSaveRQ dto){

        if (repository.existsByEmailOrUsername(dto.getMailAddress(), dto.getUsername())){
            throw new AuthException(AllException.USERNAME_OR_EMAIL_ALREADY_EXISTS);
        }
        Auth auth=save(IAuthMapper.INSTANCE.toAuth(dto));

        if (auth.getRole()== Role.ADMIN || auth.getRole()== Role.SUPERADMIN){
            adminService.saveAdmin(IAdminMapper.INSTANCE.toDto(dto), auth.getId());
        }else if (auth.getRole()== Role.CUSTOMER){

        }

    }



    // 2.yöntem
    public void saveCustomer(){

    }

    public void saveAdmin(){

    }




}
