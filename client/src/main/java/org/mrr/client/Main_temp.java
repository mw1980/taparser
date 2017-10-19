package org.mrr.client;

import org.mrr.config.ApplicationConfig;
import org.mrr.core.CodeSpecificationLogic;
import org.mrr.core.UiUnitTest;
import org.mrr.selenium.DefaultUiUnitTest;
import org.mrr.specification.CodeSpecificationLogicImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Temporary runnable main class.
 */
//TODO remove it when a real client is available.
class Main_temp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final CodeSpecificationLogic specificationParser = context.getBean("codeSpecificationLogicImpl", CodeSpecificationLogicImpl.class);
        final UiUnitTest unitTest = context.getBean("defaultUiUnitTest", DefaultUiUnitTest.class);
        unitTest.persist(
                specificationParser.codeForSpecification());
    }
}
