package org.mrr.selenium;

import org.junit.Test;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;
import org.mrr.selenium.location.CodeLocationById;
import org.mrr.selenium.location.CodeLocationByXPath;
import org.mrr.selenium.location.CodeLocationUnknown;
import org.mrr.selenium.location.SeleniumCodeLocationLogic;
import org.mrr.selenium.location.SeleniumCodeLocationVisitor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;
import static org.mrr.core.domain.IdentificationCriteria.XPATH;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

public class SeleniumCodeLocationLogicTest {

    private static final String NAME = "name";

    private final ControlsLogic controlsLogic = mock(ControlsLogic.class);
    private final SeleniumCodeLocationVisitor codeLocationVisitor = mock(SeleniumCodeLocationVisitor.class);
    private final SeleniumCodeLocationLogic underTest = new SeleniumCodeLocationLogic(controlsLogic, codeLocationVisitor);

    @Test
    public void shouldReturnTheLocationCodeOverCodeLocationVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(UNKNOWN, "value")));
        when(codeLocationVisitor.codeLocationForUnknownCriteria()).thenReturn(mock(CodeLocationUnknown.class));
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForUnknownCriteria();
    }

    @Test(expected = LoadControlsException.class)
    public void whenControlNotFound_shouldRaiseException() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(NO_CONTROL);
        underTest.locationCodeFor(NAME);
    }

    @Test
    public void shouldLoadCodeByIdOverTheVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(ID, "controlHtmlId")));
        when(codeLocationVisitor.codeLocationForId()).thenReturn(mock(CodeLocationById.class));
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForId();
    }

    @Test
    public void shouldLoadCodeByXPathOverTheVisitor() {
        when(controlsLogic.controlWithName(NAME)).thenReturn(new UiControl(NAME, new UiLocation(XPATH, "id")));
        when(codeLocationVisitor.codeLocationForXPath()).thenReturn(mock(CodeLocationByXPath.class));
        underTest.locationCodeFor(NAME);
        verify(codeLocationVisitor).codeLocationForXPath();
    }
}