package org.mrr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The spring application configuration.
 */
@Configuration
@ComponentScan("org.mrr")
public class ApplicationConfig {

    @Value("src/test/resources/org/mrr/reader/txt/ElementIdentifiers.csv")
    private String descriptionsFile;

}
