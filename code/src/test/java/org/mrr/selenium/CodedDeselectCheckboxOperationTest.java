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
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;

class CodedDeselectCheckboxOperationTest {

    @Test
    void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowException() {
        final CodeLocationLogic codeLocationLogic = mock(CodeLocationLogic.class);
        when(codeLocationLogic.locationCodeFor("notThere")).thenThrow(new LoadControlsException(""));

        assertThrows(
                LoadControlsException.class,
                () -> new CodedDeselectCheckboxOperation(codeLocationLogic)
                        .codeFor(new Action(DESELECT_CHECKBOX, "notThere"))
        );
    }

    @Test
    void shouldGenerateCodeAsExpected() {
        final CodedDeselectCheckboxOperation underTest = new CodedDeselectCheckboxOperation(new CodeLocationLogicStub());
        assertThat(underTest.codeFor(new Action(DESELECT_CHECKBOX, "agreeCookies")))
                .isEqualTo("if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}");
    }

    @Test
    void shouldHandleOnlyDeselectCheckboxActions() {
        final CodedDeselectCheckboxOperation underTest = new CodedDeselectCheckboxOperation(mock(CodeLocationLogic.class));

        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(EDIT_TEXT))).isFalse(),
                () -> assertThat(underTest.canHandle(Action.withType(DESELECT_CHECKBOX))).isTrue()
        );
    }
}