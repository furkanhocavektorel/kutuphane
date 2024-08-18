package com.vektorel.kutuphane.mapper;

import com.vektorel.kutuphane.dto.request.AdminSaveRQ;
import com.vektorel.kutuphane.dto.request.RegisterRQ;
import com.vektorel.kutuphane.dto.response.AdminRS;
import com.vektorel.kutuphane.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAdminMapper {

    IAdminMapper INSTANCE= Mappers.getMapper(IAdminMapper.class);

    Admin toAdmin(AdminSaveRQ dto);
    AdminRS toDto(Admin admin);
    AdminSaveRQ toDto(RegisterRQ dto);



}
