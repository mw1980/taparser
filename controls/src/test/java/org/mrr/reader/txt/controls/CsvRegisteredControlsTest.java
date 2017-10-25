package org.mrr.reader.txt.controls;

import org.junit.jupiter.api.Test;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;
import org.mrr.reader.txt.controls.api.ControlDescriptions;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;

/**
 * Tests for the class CsvRegisteredControls.
 */
class CsvRegisteredControlsTest {

    @Test
    void shouldTranslateValidElementAsExpected() {
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(singletonList("name id elementId"));

        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        assertThat(underTest.allRegistered())
                .isEqualTo(
                        singletonMap("name",
                                new UiControl("name", new UiLocation(ID, "elementId"))));
    }

    @Test
    void whenTranslatingEmptyList_shouldReturnEmptyUiControlMap() {
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(emptyList());

        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        assertThat(underTest.allRegistered())
                .isEqualTo(Collections.<String, UiControl>emptyMap());
    }

    @Test
    void whenTranslatingInvalidIdentificationCriteria_shouldThrowException() {
        final ControlDescriptions descriptions = mock(ControlDescriptions.class);
        when(descriptions.allDescriptions()).thenReturn(singletonList("name otherIdentificationType elementId"));
        final CsvRegisteredControls underTest = new CsvRegisteredControls(descriptions);
        assertThrows(
                LoadControlsException.class,
                underTest::allRegistered
        );
        //TODO: the test tests also the enum IdentificationCriteria. Refactor it in order to externalize the matching logic.
    }
}