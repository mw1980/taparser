package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.CsvControlDescriptions;
import org.mrr.reader.txt.controls.DefaultControlsLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class IntegrationTests {

    @Test
    void shouldLoadControlDescriptions() {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CsvControlDescriptions underTest = context.getBean("controlDescriptions", CsvControlDescriptions.class);
        assertThat(underTest.allDescriptions()).isNotNull();
    }

    @Test
    void shouldLoadControls() {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final DefaultControlsLogic underTest = context.getBean("defaultControlsLogic", DefaultControlsLogic.class);
        final Map<String, UiControl> controls = underTest.allControls();
        assertThat(controls).isNotNull();
    }
}
