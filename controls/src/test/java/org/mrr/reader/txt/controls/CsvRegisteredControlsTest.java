package org.mrr.reader.txt.controls;

import org.junit.Test;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;
import org.mrr.reader.txt.controls.api.ControlDescriptions;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;

/**
 * Tests for the class CsvRegisteredControls.
 */
public class CsvRegisteredControlsTest {

    @Test
    public void shouldTranslateValidElementAsExpected() {
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(singletonList("name id elementId"));

        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        assertThat(underTest.allRegistered(), equalTo(
                singletonMap("name",
                        new UiControl("name", new UiLocator(ID, "elementId")))));
    }

    @Test
    public void whenTranslatingEmptyList_shouldReturnEmptyUiControlMap(){
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(emptyList());

        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        assertThat(
                underTest.allRegistered(),
                equalTo(Collections.<String, UiControl>emptyMap())
        );
    }

    @Test (expected = LoadControlsException.class)
    public void whenTranslatingInvalidIdentificationCriteria_shouldThrowException(){
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(singletonList("name otherIdentificationType elementId"));
        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        underTest.allRegistered();
    }
}