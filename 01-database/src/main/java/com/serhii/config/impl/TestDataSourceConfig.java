package com.serhii.config.impl;

import com.serhii.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories("com.serhii.repository")
@EnableTransactionManagement
@ComponentScan("com.serhii")
@PropertySource(value = "classpath:application.properties")
public class TestDataSourceConfig implements DataSourceConfig {

    @Value("${hibernate.GenerateDdl}")
    private boolean HIBERNATE_GENERATE_DDL;
    @Value("${hibernate.ShowSql}")
    private boolean HIBERNATE_SHOW_SQL;
    @Value("${hibernate.PackagesToScan}")
    private String HIBERNATE_PACKAGES_TO_SCAN;

    public TestDataSourceConfig() {
        setUp();
    }

    @Override
    public void setUp() {
        System.out.println("Setting up datasource for TEST environment.");
    }

    @Bean
    @Override
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

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
