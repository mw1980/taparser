package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.DefaultParseActionLogic;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ParseActionLogicImplIntegrationTest {

    @Test
    void whenStartingApplicationContext_shouldAutowireTheParserLogic() {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final DefaultParseActionLogic parserLogic = context.getBean("defaultParseActionLogic", DefaultParseActionLogic.class);
        assertThat(parserLogic).isNotNull();
    }
}
