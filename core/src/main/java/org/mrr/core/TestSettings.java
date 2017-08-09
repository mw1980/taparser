package org.mrr.core;

/**
 * General unit test settings.
 */
public interface TestSettings {

    String basePackagePath();

    String getGeckoDriverPath();

    String completePackagePath();

    final class DummyTestSetting implements TestSettings {

        @Override
        public String basePackagePath() {
            return "base";
        }

        @Override
        public String getGeckoDriverPath() {
            return "geckoDriver";
        }

        @Override
        public String completePackagePath() {
            return "complete";
        }
    }
}