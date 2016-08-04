package org.mrr.controls;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.controls.api.ControlsSupplyAgent;
import org.mrr.controls.api.UiControl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class IntegrationTests {
    @Test
    @Ignore
    //this is actually an integration test and should be moved to its own integration folder.
    public void checkSpringInjection(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        ControlsSupplyAgent controlsSupplyAgent = context.getBean("controlsAgentImpl", ControlsSupplyAgentImpl.class);
        final Map<String, UiControl> controls = controlsSupplyAgent.supply();
        assertThat(controls, IsNull.notNullValue());
    }

    @Test
    @Ignore
    public void shouldLoadDescriptionsStrategyerFirstElementAsExpected(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CsvLoadDescriptionStrategy loadStrategy = context.getBean("csvLoadDescriptionStrategy", CsvLoadDescriptionStrategy.class);
        final List<String> descriptions = loadStrategy.descriptionsAsText();
        Assert.assertNotNull(descriptions);
        System.out.println(descriptions);
    }

}
