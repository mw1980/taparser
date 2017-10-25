package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;

class CodedClickButtonOperationTest {

    private final CodedClickButtonOperation underTest = new CodedClickButtonOperation(new CodeLocationLogicStub());

    @Test
    void shouldGenerateCodeAsExpected() {
        assertThat(
                underTest.codeFor(new Action(CLICK_BUTTON, "submit")))
                .isEqualTo("driver.findElement(By.id(\"submitHtmlId\")).click();");
    }

    @Test
    void shouldHandleOnlyClickButtonAction() {
        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(CLICK_BUTTON))).isTrue(),
                () -> assertThat(underTest.canHandle(Action.withType(EDIT_TEXT))).isFalse()
        );
    }
}