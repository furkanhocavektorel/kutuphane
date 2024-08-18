package com.vektorel.kutuphane.mapper;

import com.vektorel.kutuphane.dto.request.RegisterRQ;
import com.vektorel.kutuphane.dto.request.CustomerSaveRQ;
import com.vektorel.kutuphane.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerSaveRQ dto);
    CustomerSaveRQ toDto(RegisterRQ dto);
}
