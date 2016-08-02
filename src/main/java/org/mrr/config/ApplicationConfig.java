package org.mrr.config;

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

}
