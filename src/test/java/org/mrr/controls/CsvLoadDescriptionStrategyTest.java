package org.mrr.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;

/**
 * Tests for the class CsvLoadDescriptionStrategy.
 */
public class CsvLoadDescriptionStrategyTest {

    @Test(expected = LoadControlsException.class)
    public void shouldTranslateIOExceptionToLoadControlsException() {
        final CsvLoadDescriptionStrategy loadStrategy = new CsvLoadDescriptionStrategy("/not/existing/path");
        loadStrategy.loadDescriptions();
    }
}