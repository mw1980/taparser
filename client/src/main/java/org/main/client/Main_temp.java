package org.main.client;

import org.mrr.config.ApplicationConfig;
import org.mrr.specification.ParseSpecificationLogicImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Temporary runnable main class.
 */
//TODO remove it when a real client is available.
class Main_temp {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final ParseSpecificationLogicImpl specificationParser = context.getBean("parseSpecificationLogicImpl", ParseSpecificationLogicImpl.class);
        specificationParser.parseSpecification().forEach(System.out::println);
    }
}
