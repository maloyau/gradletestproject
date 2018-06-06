package com.serhii.config;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public interface DataConfig {
    DataSource dataSource();
    JpaVendorAdapter vendorAdapter();
    EntityManagerFactory entityManagerFactory();
    PlatformTransactionManager transactionManager();
}
