package org.mrr.reader.txt.controls;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;
import org.mrr.reader.txt.controls.api.ControlsRepository;
import org.mrr.reader.txt.controls.api.RegisteredControls;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

class DefaultControlsRepositoryTest {

    private static final String CONTROL_NAME = "name";

    private final RegisteredControls registered = mock(RegisteredControls.class);
    private final ControlsRepository underTest = new DefaultControlsRepository(registered);

    @Test
    void whenAskingForControls_shouldLoadFromRegisteredControls() {
        underTest.controls();
        verify(registered).allRegistered();
    }

    @Test
    void whenAskingForControls_shouldCashTheResult() {
        when(registered.allRegistered()).thenReturn(notEmptyControlsMap());
        //the second call should return the cached values, without trying to fetch them again from registered values
        underTest.controls();
        underTest.controls();
        verify(registered).allRegistered();
    }

    private Map<String, UiControl> notEmptyControlsMap() {
        return singletonMap(CONTROL_NAME, notEmptyControl());
    }

    private UiControl notEmptyControl() {
        return new UiControl(CONTROL_NAME, new UiLocation(ID, "nameHtmlId"));
    }

    @Test
    void shouldLoadControlByNameFromRegisteredControls() {
        underTest.controlWithName("");
        verify(registered).allRegistered();
    }

    @Test
    void shouldCacheResultWhenSearchingForControlByName() {
        when(registered.allRegistered()).thenReturn(notEmptyControlsMap());
        underTest.controlWithName("");
        underTest.controlWithName("");
        verify(registered).allRegistered();
    }

    @Test
    void whenControlNoFound_shouldReturnTheNullObject() {
        assertThat(underTest.controlWithName(CONTROL_NAME)).isEqualTo(NO_CONTROL);
    }

    @Test
    void whenSearchingForAvailableObject_shouldReturnCorrectObject() {
        when(registered.allRegistered()).thenReturn(notEmptyControlsMap());
        assertThat(underTest.controlWithName(CONTROL_NAME)).isEqualTo(notEmptyControl());
    }
}