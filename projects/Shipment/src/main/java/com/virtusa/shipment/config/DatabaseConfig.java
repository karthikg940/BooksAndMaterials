package com.virtusa.shipment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.virtusa.shipment.data.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
