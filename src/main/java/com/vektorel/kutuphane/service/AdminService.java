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


    public List<Admin> findAllAdmin() {
        return findAll();
    }

    public String metin(){
        return "bu metin kullannıcıya dönülmeyecek" +
                "yazılımcı için aciklama" +
                "buraya lütfen dikkat edin." +
                "öndemli bfdfds" +
                "fdsfsd" +
                "sd" +
                "fsd" +
                "fsd" +
                "f" +
                "sdf" +
                "sd" +
                "fssf" +
                "dsfd" +
                "ciklama olabilir." +
                "projede readme unutmayın";
    }

}
