package org.mrr.selenium;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DefaultTestSettingsTest {

    @Test
    void shouldReturnInjectedValues() {
        assertAll(
                () -> assertThat(
                        new DefaultTestSettings("base", "", "").basePackagePath(),
                        is("base")),
                () -> assertThat(
                        new DefaultTestSettings("", "complete", "").completePackagePath(),
                        is("complete")),
                () -> assertThat(
                        new DefaultTestSettings("", "", "gecko").geckoDriverPath(),
                        is("gecko"))
        );
    }
}