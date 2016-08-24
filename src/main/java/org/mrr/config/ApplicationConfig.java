package org.mrr.config;

import org.mrr.specification.FileTestSpecificationStoreImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * The spring application configuration.
 */
@PropertySource("classpath:/config.properties")
@Configuration
@ComponentScan("org.mrr")

public class ApplicationConfig {
    @Value("${test.specification.location}")
    private String testSpecificationLocation;

    @Bean
    public FileTestSpecificationStoreImpl fileTestSpecificationStore() {
        return new FileTestSpecificationStoreImpl(testSpecificationLocation);
    }
}
