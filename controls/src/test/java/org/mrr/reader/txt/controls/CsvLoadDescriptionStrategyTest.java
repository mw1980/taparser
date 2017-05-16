package org.mrr.reader.txt.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;

public class CsvLoadDescriptionStrategyTest {

    @Test(expected = LoadControlsException.class)
    public void shouldTranslateIOExceptionToLoadControlsException() {
        final CsvLoadDescriptionStrategy loadStrategy = new CsvLoadDescriptionStrategy("/not/existing/path");
        loadStrategy.loadDescriptions();
    }
}