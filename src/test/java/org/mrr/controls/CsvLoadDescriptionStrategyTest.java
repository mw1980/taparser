package org.mrr.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Tests for the class CsvLoadDescriptionStrategy.
 */
public class CsvLoadDescriptionStrategyTest {

    @Test (expected = LoadControlsException.class)
    public void shouldTranslateIOExceptionToLoadControlsException(){
       final CsvLoadDescriptionStrategy loadStrategy = new CsvLoadDescriptionStrategy();
        ReflectionTestUtils.setField(loadStrategy,"location", "/not/existing/path");
        loadStrategy.loadDescriptions();
    }
}