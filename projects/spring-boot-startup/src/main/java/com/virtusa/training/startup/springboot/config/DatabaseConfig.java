package com.virtusa.training.startup.springboot.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.virtusa.training.startup.springboot.data.repository")
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    @Primary
    DataSource dataSource(DataSourceProperties dataSourceProperties) {
        BasicDataSource dataSource = (BasicDataSource) DataSourceBuilder.create(dataSourceProperties.getClassLoader())
                        .type(BasicDataSource.class).driverClassName(dataSourceProperties.getDriverClassName())
                        .url(dataSourceProperties.getUrl()).username(dataSourceProperties.getUsername())
                        .password(dataSourceProperties.getPassword()).build();
        return dataSource;
    }
}
