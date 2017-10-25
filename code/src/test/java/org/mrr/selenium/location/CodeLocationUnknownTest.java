package org.mrr.selenium.location;

import org.junit.jupiter.api.Test;
import org.mrr.api.CodeException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CodeLocationUnknownTest {

    @Test
    void shouldReturnExpectedLocationCode() {
        final CodeLocationUnknown underTest = new CodeLocationUnknown();
        assertThrows(
                CodeException.class,
                () -> org.assertj.core.api.Assertions.assertThat(underTest.codeFor("unknown"))
        );
    }
}