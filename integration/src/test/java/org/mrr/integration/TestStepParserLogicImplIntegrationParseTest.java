package org.mrr.integration;

import org.junit.Test;
import org.mrr.DefaultParseActionLogic;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestStepParserLogicImplIntegrationParseTest {

    @Test
    public void whenStartingApplicationContext_shouldAutowireTheParserLogic(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final DefaultParseActionLogic parserLogic = context.getBean("defaultParseActionLogic", DefaultParseActionLogic.class);
        assertThat(parserLogic, notNullValue());
    }
}
