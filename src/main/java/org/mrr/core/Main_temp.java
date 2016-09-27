package org.mrr.core;

import org.mrr.config.ApplicationConfig;
import org.mrr.specification.ParseSpecificationLogicImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Temporary runnable main class.
 */
//TODO remove it when a real client is available.
class Main_temp {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final ParseSpecificationLogicImpl specificationParser = context.getBean("parseSpecificationLogicImpl", ParseSpecificationLogicImpl.class);
        final List<String> actionsInFile = specificationParser.parseSpecification();
        for (String action : actionsInFile) {
            System.out.println(action);
        }
    }
}
