package org.mrr.controls;

import org.junit.Assert;
import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Tests for the class CsvLoadDescriptionStrategy.
 */
public class CsvLoadDescriptionStrategyTest {

    //this is a unit test. Move it to its corresponding folder.
    @Test
    public void shouldLoadDescriptionsStrategyerFirstElementAsExpected(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CsvLoadDescriptionStrategy loadStrategy = context.getBean("csvLoadDescriptionStrategy", CsvLoadDescriptionStrategy.class);
        final List<String> descriptions = loadStrategy.descriptionsAsText();
        Assert.assertNotNull(descriptions);
        System.out.println(descriptions);
    }

    @Test
    public void whenLoadingValidContent_shouldLoadExpectedContent(){

        //final CsvLoadDescriptionStrategy loader = new CsvLoadDescriptionStrategy(TEST_ELEMENTS_IDENTIFIER_LOCATION);
        //final List<String> descriptions = loader.descriptionsAsText();
        //Assert.assertThat(descriptions.get(0), equalTo("user id userNameHtmlId"));
    }
}