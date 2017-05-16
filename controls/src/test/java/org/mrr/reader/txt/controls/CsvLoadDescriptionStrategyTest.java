package org.mrr.reader.txt.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;

public class CsvLoadDescriptionStrategyTest {

    @Test(expected = LoadControlsException.class)
    public void shouldTranslateIOExceptionToLoadControlsException() {
        final CsvControlDescriptions loadStrategy = new CsvControlDescriptions("/not/existing/path");
        loadStrategy.allRegistered();
    }
}