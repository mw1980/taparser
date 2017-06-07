package org.mrr.selenium;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

public class CodeEditTextfieldOperationTest {

    @Test
    public void shouldGenerateCodeAsExpected() {
        final CodeEditTextfieldOperation underTest = new CodeEditTextfieldOperation(new CodeLocationLogicStub());
        assertThat(
                underTest.codeFor(new Action(ActionType.EDIT_TEXT, "user", "newValue")))
                .isEqualTo("driver.findElement(By.id(\"userHtmlId\")).sendKeys(\"newValue\");");
    }
}