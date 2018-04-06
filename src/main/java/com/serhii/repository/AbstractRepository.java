package com.serhii.repository;

import com.serhii.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
