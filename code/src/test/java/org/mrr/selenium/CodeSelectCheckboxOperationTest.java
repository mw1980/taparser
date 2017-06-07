package org.mrr.selenium;

import org.junit.Test;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

public class CodeSelectCheckboxOperationTest {

    @Test
    public void shouldGenerateExpectedCode() {
        final CodeSelectCheckboxOperation underTest = new CodeSelectCheckboxOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(SELECT_CHECKBOX, "agreeCookies")))
                .isEqualTo("if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}");
    }

    @Test(expected = LoadControlsException.class)
    public void whenParsingTestStepWithUnknownTarget_shouldRaiseException() {
        final CodeLocationLogic codeLocationLogic = mock(CodeLocationLogic.class);
        when(codeLocationLogic.locationCodeFor("unknownTarget")).thenThrow(new LoadControlsException(""));
        new CodeSelectCheckboxOperation(codeLocationLogic)
                .codeFor(new Action(SELECT_CHECKBOX, "unknownTarget"));
    }
}