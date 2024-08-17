package com.vektorel.kutuphane.util;

import java.util.List;
import java.util.Optional;

public interface IServiceManager <T,ID> {

    T save(T t);
    T update(T t);
    T softDelete(T t);
    void deleteById(ID id);
    void delete(T t);
    Optional<T> findById(ID id);
    List<T> findAll();

}
