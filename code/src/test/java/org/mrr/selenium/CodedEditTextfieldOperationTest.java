package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;

class CodedEditTextfieldOperationTest {

    @Test
    void shouldGenerateCodeAsExpected() {
        final CodedEditTextfieldOperation underTest = new CodedEditTextfieldOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(EDIT_TEXT, "user", "newValue")))
                .isEqualTo("driver.findElement(By.id(\"userHtmlId\")).sendKeys(\"newValue\");");
    }

    @Test
    void shouldHandleOnlyEditTextfieldActions() {
        final CodedEditTextfieldOperation underTest = new CodedEditTextfieldOperation(mock(CodeLocationLogic.class));
        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(EDIT_TEXT))).isTrue(),
                () -> assertThat(underTest.canHandle(Action.withType(CLICK_BUTTON))).isFalse()
        );
    }
}