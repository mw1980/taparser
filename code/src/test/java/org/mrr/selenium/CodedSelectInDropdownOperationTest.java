package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

class CodedSelectInDropdownOperationTest {

    @Test
    void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
        final CodeLocationLogic locatorCodeOperation = mock(CodeLocationLogic.class);
        when(locatorCodeOperation.locationCodeFor("withoutIdentifier")).thenThrow(new LoadControlsException("control not found"));
        assertThrows(
                LoadControlsException.class,
                () -> new CodedSelectInDropdownOperation(locatorCodeOperation)
                        .codeFor(new Action(SELECT_IN_DROPDOWN, "withoutIdentifier"))
        );
    }

    @Test
    void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
        final CodedSelectInDropdownOperation underTest = new CodedSelectInDropdownOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(SELECT_IN_DROPDOWN, "mydropdown", "ui option")))
                .isEqualToIgnoringCase("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
    }

    @Test
    void shouldHandleOnlyTheSelectInDropdownActions() {
        final CodedSelectInDropdownOperation underTest = new CodedSelectInDropdownOperation(new CodeLocationLogicStub());
        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(CLICK_BUTTON))).isFalse(),
                () -> assertThat(underTest.canHandle(Action.withType(SELECT_IN_DROPDOWN))).isTrue()
        );
    }
}