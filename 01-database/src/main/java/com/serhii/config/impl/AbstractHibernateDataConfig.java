package com.serhii.config.impl;

import com.serhii.config.DataConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@EnableJpaRepositories("com.serhii.repository")
@EnableTransactionManagement
@ComponentScan("com.serhii")
@PropertySource(value = "classpath:application.properties")
public abstract class AbstractHibernateDataConfig implements DataConfig {

    @Value("${hibernate.DatabasePlatform}")
    protected String HIBERNATE_DATABASE_PLATFORM;
    @Value("${hibernate.GenerateDdl}")
    protected boolean HIBERNATE_GENERATE_DDL;
    @Value("${hibernate.ShowSql}")
    protected boolean HIBERNATE_SHOW_SQL;
    @Value("${hibernate.PackagesToScan}")
    protected String HIBERNATE_PACKAGES_TO_SCAN;
    @Value("${spring.datasource.DriverClassName}")
    protected String DATASOURCE_DRIVER_CLASS_NAME;
    @Value("${spring.datasource.Url}")
    protected String DATASOURCE_URL;
    @Value("${spring.datasource.Username}")
    protected String DATASOURCE_USERNAME;
    @Value("${spring.datasource.Password}")
    protected String DATASOURCE_PASSWORD;
    @Value("${hikari.MaximumPoolSize}")
    protected int HIKARI_MAX_POOL_SIZE;
    @Value("${hikari.CachePrepStmts}")
    protected String HIKARI_CACHE_PREP_STMTS;
    @Value("${hikari.PrepStmtCacheSize}")
    protected String HIKARI_PREP_STMTS_CACHE_SIZE;
    @Value("${hikari.PrepStmtCacheSqlLimit}")
    protected String HIKARI_PREP_STMTS_CACHE_SQL_LIMIT;

    @Bean
    public HibernateJpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(HIBERNATE_GENERATE_DDL);
        vendorAdapter.setShowSql(HIBERNATE_SHOW_SQL);
        return vendorAdapter;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter());
        factory.setPackagesToScan(HIBERNATE_PACKAGES_TO_SCAN);
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
