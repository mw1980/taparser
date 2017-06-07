package org.mrr.selenium;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.api.CodeException;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

public class DefaultCodeLocationLogicTest {

    private static final String NAME = "name";

    @Mock
    private ControlsLogic controlsLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CodeException.class)
    public void whenUiControlTypeUnknown_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(unknownControl());
        new DefaultCodeLocationLogic(controlsLogic).locationCodeFor(NAME);
    }

    private UiControl unknownControl() {
        return new UiControl(NAME, new UiLocation(UNKNOWN, "value"));
    }

    @Test(expected = LoadControlsException.class)
    public void whenControlNotFound_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(NO_CONTROL);
        new DefaultCodeLocationLogic(controlsLogic).locationCodeFor(NAME);
    }

    @Test
    public void shouldGenerateExpectedCodeIfElementIdentifiedById() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(controlIdentifiedById());
        assertEquals(
                new DefaultCodeLocationLogic(controlsLogic).locationCodeFor(NAME),
                "By.id(\"controlHtmlId\")"
        );
    }

    private UiControl controlIdentifiedById() {
        return new UiControl(NAME, new UiLocation(ID, "controlHtmlId"));
    }
}