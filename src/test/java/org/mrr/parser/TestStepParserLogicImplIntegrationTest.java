package org.mrr.parser;

import org.junit.Assert;
import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;

public class TestStepParserLogicImplIntegrationTest {

    @Test
    public void whenStartingApplicationContext_shouldAutowireTheParserLogic(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final TestStepParserLogicImpl parserLogic = context.getBean("testStepParserLogicImpl", TestStepParserLogicImpl.class);
        Assert.assertThat(parserLogic, notNullValue());
    }
}
