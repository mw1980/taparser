package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

class CodedSelectCheckboxOperationTest {

    @Test
    void shouldGenerateExpectedCode() {
        final CodedSelectCheckboxOperation underTest = new CodedSelectCheckboxOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(SELECT_CHECKBOX, "agreeCookies")))
                .isEqualTo("if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}");
    }

    @Test
    void shouldHandleOnlySelectCheckboxOperation() {
        final CodedSelectCheckboxOperation underTest = new CodedSelectCheckboxOperation(new CodeLocationLogicStub());
        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(CLICK_BUTTON))).isFalse(),
                () -> assertThat(underTest.canHandle(Action.withType(SELECT_CHECKBOX))).isTrue()
        );
    }
}