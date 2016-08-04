package org.mrr.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;
import org.mrr.controls.api.UiControl;
import org.mrr.controls.api.UiLocator;

import java.util.Collections;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mrr.core.IdentificationCriteria.ID;

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

    @Test
    public void whenTranslatingEmptyList_shouldReturnEmptyUiControlMap(){
        final CsvTranslateControlsStrategy translator = new CsvTranslateControlsStrategy();
        assertThat(
                translator.translate(Collections.<String>emptyList()),
                equalTo(Collections.<String, UiControl>emptyMap())
        );
    }


    @Test (expected = LoadControlsException.class)
    public void whenTranslatingInvalidIdentificationCriteria_shouldThrowException(){
        final CsvTranslateControlsStrategy translator = new CsvTranslateControlsStrategy();
        translator.translate(singletonList("name otherIdentificationType elementId"));
    }
}