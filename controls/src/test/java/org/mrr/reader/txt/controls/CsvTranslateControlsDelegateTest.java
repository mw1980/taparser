package org.mrr.reader.txt.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;

import java.util.Collections;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mrr.core.domain.IdentificationCriteria.ID;

/**
 * Tests for the class CsvTranslateControlsDelegate.
 */
public class CsvTranslateControlsDelegateTest {

    @Test
    public void shouldTranslateValidElementAsExpected() {
        final CsvTranslateControlsDelegate translator = new CsvTranslateControlsDelegate();
        final Map<String, UiControl> calculated = translator.translate(singletonList("name id elementId"));
        final Map<String, UiControl> expected = singletonMap(
                "name",
                new UiControl("name", new UiLocator(ID, "elementId")));

        assertThat(calculated, equalTo(expected));
    }

    @Test
    public void whenTranslatingEmptyList_shouldReturnEmptyUiControlMap(){
        final CsvTranslateControlsDelegate translator = new CsvTranslateControlsDelegate();
        assertThat(
                translator.translate(Collections.emptyList()),
                equalTo(Collections.<String, UiControl>emptyMap())
        );
    }


    @Test (expected = LoadControlsException.class)
    public void whenTranslatingInvalidIdentificationCriteria_shouldThrowException(){
        final CsvTranslateControlsDelegate translator = new CsvTranslateControlsDelegate();
        translator.translate(singletonList("name otherIdentificationType elementId"));
    }
}