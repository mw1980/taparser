package org.mrr.selenium.location;

import org.junit.jupiter.api.Test;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;
import static org.mrr.core.domain.IdentificationCriteria.XPATH;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

class SeleniumCodeLocationLogicTest {

    private static final String NAME = "name";

    private final ControlsLogic controlsLogic = mock(ControlsLogic.class);
    private final SeleniumCodeLocationVisitor codeLocationVisitor = mock(SeleniumCodeLocationVisitor.class);
    private final SeleniumCodeLocationLogic underTest = new SeleniumCodeLocationLogic(controlsLogic, codeLocationVisitor);
    private final CodeLocationById codeLocationById = mock(CodeLocationById.class);
    private final CodeLocationByXPath codeLocationByXPath = mock(CodeLocationByXPath.class);

    @Test
    void shouldReturnTheLocationCodeOverCodeLocationVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(UNKNOWN, "value")));
        when(codeLocationVisitor.codeLocationForUnknownCriteria()).thenReturn(mock(CodeLocationUnknown.class));
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForUnknownCriteria();
    }

    @Test
    void whenControlNotFound_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(NO_CONTROL);
        assertThrows(
                LoadControlsException.class,
                () -> underTest.locationCodeFor(NAME));
    }

    @Test
    void shouldLoadCodeByIdOverTheVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(ID, "controlHtmlId")));
        when(codeLocationVisitor.codeLocationForId()).thenReturn(codeLocationById);
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForId();
        verify(codeLocationById).codeFor("controlHtmlId");
    }

    @Test
    void shouldLoadCodeByXPathOverTheVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(XPATH, "xpath")));
        when(codeLocationVisitor.codeLocationForXPath()).thenReturn(codeLocationByXPath);
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForXPath();
        verify(codeLocationByXPath).codeFor("xpath");
    }
}