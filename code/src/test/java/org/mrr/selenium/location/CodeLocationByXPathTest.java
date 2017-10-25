package org.mrr.selenium.location;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CodeLocationByXPathTest {

    @Test
    void shouldReturnExpectedLocationCode() {
        final CodeLocationByXPath underTest = new CodeLocationByXPath();
        assertAll(
                () -> assertThat(underTest.codeFor("xpathExpression")).isEqualToIgnoringCase("by.xpath(\"xpathExpression\")"),
                () -> assertThat(underTest.codeFor("")).isEqualToIgnoringCase("by.xpath(\"\")")
        );
    }
}