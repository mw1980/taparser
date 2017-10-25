package org.mrr.selenium.location;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SeleniumCodeLocationVisitorTest {

    private final SeleniumCodeLocationVisitor underTest = new SeleniumCodeLocationVisitor();

    @Test
    void shouldReturnExpectedCodeLocations() {
        assertAll(
                () -> assertThat(underTest.codeLocationForId()).isInstanceOf(CodeLocationById.class),
                () -> assertThat(underTest.codeLocationForXPath()).isInstanceOf(CodeLocationByXPath.class),
                () -> assertThat(underTest.codeLocationForUnknownCriteria()).isInstanceOf(CodeLocationUnknown.class)
        );
    }
}