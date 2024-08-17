package com.vektorel.kutuphane.util;

import com.vektorel.kutuphane.entity.BaseEntity;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ServiceManager <T extends BaseEntity,ID> implements IServiceManager<T,ID> {

    private final JpaRepository<T,ID> jpaRepository;

    public ServiceManager(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T t) {
        t.setCreateDate(LocalDateTime.now().toString());
        t.setUpdateDate(LocalDateTime.now().toString());
        t.setDeleted(false);
        return jpaRepository.save(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(LocalDateTime.now().toString());
        return jpaRepository.save(t);
    }

    @Override
    public T softDelete(T t) {
        t.setDeleted(true);
        return update(t);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void delete(T t) {
        jpaRepository.delete(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }
}
