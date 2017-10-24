package org.mrr.selenium;

import org.mrr.core.TestSettings;

/**
 * Default test settings.
 */
public class DefaultTestSettings implements TestSettings {

    private final String basePackagePath;
    private final String testsFolderPath;
    private final String geckoDriverPath;

    public DefaultTestSettings(final String pathToBasePackage,
                               final String pathToTestsFolder,
                               final String pathToGeckoDriver) {
        this.basePackagePath = pathToBasePackage;
        this.testsFolderPath = pathToTestsFolder;
        this.geckoDriverPath = pathToGeckoDriver;
    }

    @Override
    public String basePackagePath() {
        return basePackagePath;
    }

    @Override
    public String geckoDriverPath() {
        return geckoDriverPath;
    }

    @Override
    public String completePackagePath() {
        return testsFolderPath;
    }
}