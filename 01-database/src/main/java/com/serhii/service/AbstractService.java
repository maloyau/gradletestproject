package com.serhii.service;

import com.serhii.entity.AbstractEntity;

import java.util.List;

public interface AbstractService<T extends AbstractEntity> {
    void save(List<T> entities);
    void save(T entity);
    T findById(Long id);
    void delete(T entity);
    void deleteById(Long id);
    List<T> findAll();
    void deleteAll();
}
