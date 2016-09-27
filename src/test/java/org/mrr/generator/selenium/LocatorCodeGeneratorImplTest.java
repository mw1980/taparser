package org.mrr.generator.selenium;

import org.junit.Test;
import org.mockito.Mockito;
import org.mrr.controls.CodeGenerationException;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.IdentificationCriteria;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;
import org.mrr.generator.LocatorCodeGenerator;

import static org.mockito.Mockito.when;

public class LocatorCodeGeneratorImplTest {


    private static final String NAME = "name";

    @Test(expected = CodeGenerationException.class)
    public void whenUiControlTypeUnknown_shouldRaiseException() {
        final ControlsLogic controlsLogic = Mockito.mock(ControlsLogic.class);
        when(controlsLogic.findControlByName(NAME)).thenReturn(unknownControl());
        final LocatorCodeGenerator generator = new LocatorCodeGeneratorImpl(controlsLogic);
        generator.identificationCodeFor(NAME);
    }

    private UiControl unknownControl() {
        return new UiControl(NAME, new UiLocator(IdentificationCriteria.UNKNOWN, "value"));
    }

    @Test(expected = LoadControlsException.class)
    public void whenControlNotFound_shouldRaiseException() {
        final ControlsLogic controlsLogic = Mockito.mock(ControlsLogic.class);
        Mockito.when(controlsLogic.findControlByName(NAME)).thenReturn(UiControl.NO_CONTROL);
        LocatorCodeGenerator generator = new LocatorCodeGeneratorImpl(controlsLogic);
        generator.identificationCodeFor(NAME);
    }
}