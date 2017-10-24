package org.mrr.selenium;

import org.junit.Test;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

public class CodeDeselectCheckboxOperationTest {

    @Test(expected = LoadControlsException.class)
    public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowException() {
        final CodeLocationLogic codeLocationLogic = mock(CodeLocationLogic.class);
        when(codeLocationLogic.locationCodeFor("notThere")).thenThrow(new LoadControlsException(""));
        new CodedDeselectCheckboxCodeOperation(codeLocationLogic)
                .codeFor(new Action(DESELECT_CHECKBOX, "notThere"));
    }

    @Test
    public void shouldGenerateCodeAsExpected() {
        final CodedDeselectCheckboxCodeOperation underTest = new CodedDeselectCheckboxCodeOperation(new CodeLocationLogicStub());
        assertThat(underTest.codeFor(new Action(DESELECT_CHECKBOX, "agreeCookies")))
                .isEqualTo("if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}");
    }
}