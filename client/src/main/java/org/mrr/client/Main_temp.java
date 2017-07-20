package org.mrr.client;

import org.mrr.config.ApplicationConfig;
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
        final CodeSpecificationLogicImpl specificationParser = context.getBean("codeSpecificationLogicImpl", CodeSpecificationLogicImpl.class);
        //specificationParser.codeForSpecification().forEach((testAction) -> System.out.println(testAction.code()));
        new DefaultUiUnitTest().persist(
                specificationParser.codeForSpecification());
    }
}
