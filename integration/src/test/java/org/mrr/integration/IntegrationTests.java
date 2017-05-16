package org.mrr.integration;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.ControlsLogicImpl;
import org.mrr.reader.txt.controls.CsvControlDescriptions;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;

public class IntegrationTests {

    @Test
    public void shouldLoadDescriptionsStrategyerFirstElementAsExpected(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CsvControlDescriptions loadStrategy = context.getBean("controlDescriptions", CsvControlDescriptions.class);
        assertNotNull(loadStrategy.allRegistered());
    }

    @Test
    public void shouldLoadUiElementsWhenCalledFromControlsLogicClass(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final ControlsLogicImpl controlsLogic = context.getBean("controlsLogicImpl", ControlsLogicImpl.class);
        final Map<String, UiControl> controls = controlsLogic.allControls();
        assertThat(controls, notNullValue());
    }
}
