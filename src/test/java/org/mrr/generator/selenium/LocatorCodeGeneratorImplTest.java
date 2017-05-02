package org.mrr.generator.selenium;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.controls.CodeGenerationException;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

public class LocatorCodeGeneratorImplTest {

    private static final String NAME = "name";

    @Mock
    private ControlsLogic controlsLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CodeGenerationException.class)
    public void whenUiControlTypeUnknown_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(unknownControl());
        new LocatorCodeGeneratorImpl(controlsLogic).identificationCodeFor(NAME);
    }

    private UiControl unknownControl() {
        return new UiControl(NAME, new UiLocator(UNKNOWN, "value"));
    }

    @Test(expected = LoadControlsException.class)
    public void whenControlNotFound_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(NO_CONTROL);
        new LocatorCodeGeneratorImpl(controlsLogic).identificationCodeFor(NAME);
    }

    @Test
    public void shouldGenerateExpectedCodeIfElementIdentifiedById() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(controlIdentifiedById());
        assertEquals(
                new LocatorCodeGeneratorImpl(controlsLogic).identificationCodeFor(NAME),
                "By.id(\"controlHtmlId\")"
        );
    }

    private UiControl controlIdentifiedById() {
        return new UiControl(NAME, new UiLocator(ID, "controlHtmlId"));
    }
}