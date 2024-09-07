package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.AdminSaveRQ;
import com.vektorel.kutuphane.dto.response.AdminRS;
import com.vektorel.kutuphane.entity.Admin;
import com.vektorel.kutuphane.exception.AllException;
import com.vektorel.kutuphane.exception.custom.AdminException;
import com.vektorel.kutuphane.mapper.IAdminMapper;
import com.vektorel.kutuphane.repository.IAdminRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService extends ServiceManager<Admin,Long> {

    private final IAdminRepository repository;

    public AdminService (IAdminRepository repository){
        super(repository);
        this.repository=repository;
    }

    public AdminRS saveAdmin(AdminSaveRQ dto,Long authId){
        Admin admin=IAdminMapper.INSTANCE.toAdmin(dto);
        admin.setAuthId(authId);
        return IAdminMapper.INSTANCE.toDto(save(admin));
    }

    public AdminRS findAdminById(Long id){
        Admin admin=findById(id).orElseThrow(()-> new AdminException(AllException.ADMIN_NOT_FOUND));
        return IAdminMapper.INSTANCE.toDto(admin);
    }

    public Optional<Admin> findByAuthId(Long authId){
        return repository.findByAuthId(authId);
    }

    public int hesap(){
        int sayi=33;
        int sayi2=100;

        int sonuc = sayi2+sayi/3;
        return sonuc;
    }

    public List<Admin> findAllAdmin() {
        return findAll();
    }

}
