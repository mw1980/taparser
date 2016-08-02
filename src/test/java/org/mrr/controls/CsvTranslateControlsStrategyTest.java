package org.mrr.controls;

import org.junit.Test;
import org.mrr.controls.api.LoadControlsException;
import org.mrr.controls.api.UiControl;
import org.mrr.controls.api.UiLocator;

import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mrr.IdentificationType.ID;

/**
 * Tests for the class CsvTranslateControlsStrategy.
 */
public class CsvTranslateControlsStrategyTest {

    @Test
    public void shouldTranslateValidElementAsExpected() {
        final CsvTranslateControlsStrategy translator = new CsvTranslateControlsStrategy();
        final Map<String, UiControl> calculated = translator.translate(singletonList("name id elementId"));
        final Map<String, UiControl> expected = singletonMap(
                "name",
                new UiControl("name",
                        new UiLocator(ID, "elementId")));

        assertThat(calculated, equalTo(expected));
    }

    @Test (expected = LoadControlsException.class)
    public void whenTranslatingInvalidControlType_shouldThrowException(){
        final CsvTranslateControlsStrategy translator = new CsvTranslateControlsStrategy();
        translator.translate(singletonList("name otherIdentificationType elementId"));
    }
}