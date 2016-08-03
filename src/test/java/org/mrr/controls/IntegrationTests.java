package org.mrr.controls;

import org.hamcrest.core.IsNull;
import org.junit.Ignore;
import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.controls.api.ControlsAgent;
import org.mrr.controls.api.UiControl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class IntegrationTests {
    @Test
    @Ignore
    //this is actually an integration test and should be moved to its own integration folder.
    public void checkSpringInjection(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        ControlsAgent controlsAgent = context.getBean("controlsAgentImpl", ControlsAgentImpl.class);
        final Map<String, UiControl> controls = controlsAgent.supply();
        assertThat(controls, IsNull.notNullValue());
        System.out.println(controls);
    }
}
