package org.mrr.selenium;

import org.junit.Test;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

public class CodeSelectInDropdownOperationTest {

    @Test(expected = LoadControlsException.class)
    public void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
        final CodeLocationLogic locatorCodeOperation = mock(CodeLocationLogic.class);
        when(locatorCodeOperation.locationCodeFor("withoutIdentifier")).thenThrow(new LoadControlsException("control not found"));
        new CodedSelectInDropdownCodeOperation(locatorCodeOperation)
                .codeFor(new Action(SELECT_IN_DROPDOWN, "withoutIdentifier"));
    }

    @Test
    public void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
        final CodedSelectInDropdownCodeOperation underTest = new CodedSelectInDropdownCodeOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(SELECT_IN_DROPDOWN, "mydropdown", "ui option")))
                .isEqualToIgnoringCase("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
    }
}