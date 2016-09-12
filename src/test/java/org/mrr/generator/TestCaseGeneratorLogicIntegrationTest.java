package org.mrr.generator;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.TestStepGeneratorLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestCaseGeneratorLogicIntegrationTest {

    @Test
    public void shouldLoadNotNullGeneratorLogicFromApplicationContext(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final TestStepGeneratorLogic generatorLogic = context.getBean("testStepGeneratorLogicImpl", TestStepGeneratorLogic.class);
        assertThat(generatorLogic, notNullValue());
    }
}