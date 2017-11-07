package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.CodeActionLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


class CodeActionLogicIntegrationTest {

    @Test
    void codeActionLogicBeanShouldBeAvailable() {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        assertThat(context.getBean("defaultCodeActionLogic", CodeActionLogic.class)).isNotNull();
    }
}