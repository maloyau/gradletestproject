package com.serhii.config.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class ProductionDataConfig extends AbstractHibernateDataConfig {

    @Bean
    @Override
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
        hikariConfig.setJdbcUrl(DATASOURCE_URL);
        hikariConfig.setUsername(DATASOURCE_USERNAME);
        hikariConfig.setPassword(DATASOURCE_PASSWORD);
        hikariConfig.setMaximumPoolSize(HIKARI_MAX_POOL_SIZE);
        hikariConfig.addDataSourceProperty("cachePrepStmts", HIKARI_CACHE_PREP_STMTS);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize" , HIKARI_PREP_STMTS_CACHE_SIZE);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", HIKARI_PREP_STMTS_CACHE_SQL_LIMIT);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    @Override
    public HibernateJpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = super.vendorAdapter();
        vendorAdapter.setDatabasePlatform(HIBERNATE_DATABASE_PLATFORM);
        return vendorAdapter;
    }
}
