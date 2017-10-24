package org.mrr.integration;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.CodeActionLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestCaseGeneratorLogicIntegrationTest {

    @Test
    public void shouldLoadNotNullGeneratorLogicFromApplicationContext(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CodeActionLogic generateLogic = context.getBean("defaultCodeActionLogic", CodeActionLogic.class);
        assertThat(generateLogic, notNullValue());
    }
}