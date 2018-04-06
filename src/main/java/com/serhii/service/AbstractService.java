package com.serhii.service;

import com.serhii.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {
    void save(T entity);
}
