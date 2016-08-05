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
        final AutomationCodeGenerator codeGenerator = context.getBean("automationCodeGenerator", AutomationCodeGenerator.class);
        final String filePath = "src/main/resources/org/mrr/txt/FirstTestCase.txt";
        final List<String> actionsInFile = codeGenerator.createCodeForActionsInFile(filePath);
        for (String action : actionsInFile) {
            System.out.println(action);
        }
    }
}
