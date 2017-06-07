package org.mrr.integration;

import org.junit.Test;
import org.mrr.DefaultParseTestActionLogic;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestStepParserLogicImplIntegrationParseTest {

    @Test
    public void whenStartingApplicationContext_shouldAutowireTheParserLogic(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final DefaultParseTestActionLogic parserLogic = context.getBean("defaultParseTestActionLogic", DefaultParseTestActionLogic.class);
        assertThat(parserLogic, notNullValue());
    }
}
