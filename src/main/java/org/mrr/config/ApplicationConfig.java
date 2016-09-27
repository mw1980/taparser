package org.mrr.config;

import org.mrr.controls.CsvLoadDescriptionStrategy;
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
    private String specificationLocation;

    @Value("${test.controls.location}")
    private String controlsLocation;

    @Bean
    public FileTestSpecificationStoreImpl fileTestSpecificationStore() {
        return new FileTestSpecificationStoreImpl(specificationLocation);
    }

    @Bean
    public CsvLoadDescriptionStrategy loadDescriptionStrategy() {
        return new CsvLoadDescriptionStrategy(controlsLocation);
    }
}
