package org.mrr.integration;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.TestStepGenerateLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestCaseGeneratorLogicIntegrationTest {

    @Test
    public void shouldLoadNotNullGeneratorLogicFromApplicationContext(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final TestStepGenerateLogic generateLogic = context.getBean("testStepGenerateLogicImpl", TestStepGenerateLogic.class);
        assertThat(generateLogic, notNullValue());
    }
}