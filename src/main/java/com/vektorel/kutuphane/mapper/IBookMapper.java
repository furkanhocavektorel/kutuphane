package com.vektorel.kutuphane.mapper;

import com.vektorel.kutuphane.dto.request.BookSaveRQRecord;
import com.vektorel.kutuphane.dto.response.BookResponse;
import com.vektorel.kutuphane.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBookMapper {
    IBookMapper INSTANCE = Mappers.getMapper(IBookMapper.class);

    BookResponse toDto(Book book);
    Book toBook(BookSaveRQRecord dto);
}
