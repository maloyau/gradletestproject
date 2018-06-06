package com.serhii.config;

import javax.sql.DataSource;


public interface DataSourceConfig {
    void setUp();
    DataSource dataSource();
}
