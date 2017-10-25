package org.mrr.selenium.location;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CodeLocationByIdTest {

    @Test
    void shouldReturnExpectedLocationCode() {
        final CodeLocationById underTest = new CodeLocationById();
        assertAll(
                () -> assertThat(underTest.codeFor("htmlId")).isEqualToIgnoringCase("by.id(\"htmlId\")"),
                () -> assertThat(underTest.codeFor("")).isEqualToIgnoringCase("by.id(\"\")")
        );
    }
}