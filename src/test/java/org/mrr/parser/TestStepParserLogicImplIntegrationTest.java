package org.mrr.parser;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestStepParserLogicImplIntegrationTest {

    @Test
    public void whenStartingApplicationContext_shouldAutowireTheParserLogic(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final TestStepParseLogicImpl parserLogic = context.getBean("testStepParseLogicImpl", TestStepParseLogicImpl.class);
        assertThat(parserLogic, notNullValue());
    }
}
