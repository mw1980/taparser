package org.mrr.selenium;

import org.junit.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class CodeClickButtonOperationTest {

    @Test
    public void shouldGenerateCodeAsExpected() {
        final CodedClickButtonCodeOperation underTest = new CodedClickButtonCodeOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(CLICK_BUTTON, "submit")))
                .isEqualTo("driver.findElement(By.id(\"submitHtmlId\")).click();");
    }
}