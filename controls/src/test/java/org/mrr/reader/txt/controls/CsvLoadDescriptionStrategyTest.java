package org.mrr.reader.txt.controls;

import org.junit.jupiter.api.Test;
import org.mrr.core.LoadControlsException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvLoadDescriptionStrategyTest {

    @Test
    void shouldTranslateIOExceptionToLoadControlsException() {
        final CsvControlDescriptions underTest = new CsvControlDescriptions("/not/existing/path");
        assertThrows(
                LoadControlsException.class,
                underTest::allDescriptions
        );
    }
}