package org.mrr.selenium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DefaultTestSettingsTest {

    @Test
    void shouldReturnInjectedValues() {
        assertAll(
                () -> assertThat(
                        new DefaultTestSettings("base", "", "").basePackagePath())
                        .isEqualTo("base"),
                () -> assertThat(
                        new DefaultTestSettings("", "complete", "").completePackagePath())
                        .isEqualTo("complete"),
                () -> assertThat(
                        new DefaultTestSettings("", "", "gecko").geckoDriverPath())
                        .isEqualTo("gecko")
        );
    }
}