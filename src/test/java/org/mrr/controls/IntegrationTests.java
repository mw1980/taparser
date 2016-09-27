package org.mrr.controls;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.controls.api.ControlsSupplyDelegate;
import org.mrr.core.domain.UiControl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;

public class IntegrationTests {
    @Test
    public void checkSpringInjection(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        ControlsSupplyDelegate controlsSupplyDelegate = context.getBean("controlsSupplyDelegateImpl", ControlsSupplyDelegateImpl.class);
        final Map<String, UiControl> controls = controlsSupplyDelegate.supply();
        assertThat(controls, notNullValue());
    }

    @Test
    public void shouldLoadDescriptionsStrategyerFirstElementAsExpected(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CsvLoadDescriptionStrategy loadStrategy = context.getBean("loadDescriptionStrategy", CsvLoadDescriptionStrategy.class);
        final List<String> descriptions = loadStrategy.loadDescriptions();
        assertNotNull(descriptions);
        System.out.println(descriptions);
    }

    @Test
    public void shouldLoadUiElementsWhenCalledFromControlsLogicClass(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final ControlsLogicImpl controlsLogic = context.getBean("controlsLogicImpl", ControlsLogicImpl.class);
        final Map<String, UiControl> controls = controlsLogic.loadControlsFromCsvFile();
        assertThat(controls, notNullValue());
    }
}
