package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

class CodedLoadPageOperationTest {

    @Test
    void testGenerateCode() throws Exception {
        final CodedLoadPageOperation underTest = new CodedLoadPageOperation();
        assertThat(
                underTest.codeFor(new Action(LOAD_PAGE, "", "www.google.com")))
                .isEqualTo("driver.get(\"www.google.com\");");
    }

    @Test
    void shouldHandleOnlyLoadPageOperations() {
        final CodedLoadPageOperation underTest = new CodedLoadPageOperation();
        assertAll(
                () -> assertThat(underTest.canHandle(Action.withType(CLICK_BUTTON))).isFalse(),
                () -> assertThat(underTest.canHandle(Action.withType(LOAD_PAGE))).isTrue()
        );
    }
}