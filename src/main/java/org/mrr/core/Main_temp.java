package org.mrr.core;

import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Temporary runnable main class.
 */
//TODO remove it.
class Main_temp {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        final ParserLogicImpl codeGenerator = context.getBean("parserLogicImpl", ParserLogicImpl.class);
        final List<String> actionsInFile = codeGenerator.parseSpecification();
        for (String action : actionsInFile) {
            System.out.println(action);
        }
    }
}
