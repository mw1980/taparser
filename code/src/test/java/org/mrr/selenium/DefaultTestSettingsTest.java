package org.mrr.selenium;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DefaultTestSettingsTest {

    @Test
    public void shouldReturnInjectedBasePath() {
        assertThat(
                new DefaultTestSettings("base", "", "").basePackagePath(),
                is("base"));
    }

    @Test
    public void shouldReturnInjectedCompletePath() {
        assertThat(
                new DefaultTestSettings("", "complete", "").completePackagePath(),
                is("complete")
        );
    }

    @Test
    public void shouldReturnInjectedPathToGecko() {
        assertThat(
                new DefaultTestSettings("", "", "gecko").getGeckoDriverPath(),
                is("gecko")
        );
    }
}