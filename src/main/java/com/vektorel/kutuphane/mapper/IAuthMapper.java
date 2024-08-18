package com.vektorel.kutuphane.mapper;

import com.vektorel.kutuphane.dto.request.AuthSaveRQ;
import com.vektorel.kutuphane.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE= Mappers.getMapper(IAuthMapper.class);

    @Mapping(target = "email",source = "mailAddress")
    Auth toAuth (AuthSaveRQ dto);
}
