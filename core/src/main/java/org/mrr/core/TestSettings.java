package org.mrr.core;

/**
 * General unit test settings.
 */
public interface TestSettings {

    String basePackagePath();

    String geckoDriverPath();

    String completePackagePath();

    final class DummyTestSetting implements TestSettings {

        @Override
        public String basePackagePath() {
            return "base";
        }

        @Override
        public String geckoDriverPath() {
            return "geckoDriver";
        }

        @Override
        public String completePackagePath() {
            return "complete";
        }
    }
}