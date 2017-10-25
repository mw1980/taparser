package org.mrr.config;

import org.mrr.core.TestSettings;
import org.mrr.core.TestSpecificationStore;
import org.mrr.reader.txt.controls.CsvControlDescriptions;
import org.mrr.reader.txt.controls.api.ControlDescriptions;
import org.mrr.selenium.DefaultTestSettings;
import org.mrr.specification.FileTestSpecificationStore;
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

    @Value("${test.files.base.package.path}")
    private String baseTestsPackagePath;

    @Value("${test.files.complete.package.path}")
    private String completeTestsPackagePath;

    @Value("${gecko.driver.path}")
    private String geckoDriverPath;

    @Bean
    public TestSpecificationStore fileTestSpecificationStore() {
        return new FileTestSpecificationStore(specificationLocation);
    }

    @Bean
    public ControlDescriptions controlDescriptions() {
        return new CsvControlDescriptions(controlsLocation);
    }

    @Bean
    public TestSettings testSettings() {
        return new DefaultTestSettings(baseTestsPackagePath, completeTestsPackagePath, geckoDriverPath);
    }
}
