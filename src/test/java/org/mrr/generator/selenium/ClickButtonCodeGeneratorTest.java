package org.mrr.generator.selenium;

import org.junit.Test;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class ClickButtonCodeGeneratorTest {

    @Test
    public void shouldGenerateCodeAsExpected() {
        final IdCodeGenerator idCodeGenerator = new IdCodeGeneratorStub();
        final TestStep testStep = new TestStep(CLICK_BUTTON, "submit");
        final ClickButtonCodeGenerator clickButtonCodeGenerator = new ClickButtonCodeGenerator(idCodeGenerator);
        assertThat(clickButtonCodeGenerator.generateCode(testStep)).isEqualTo("driver.findElement(By.id(\"submitHtmlId\")).click();");
    }
}