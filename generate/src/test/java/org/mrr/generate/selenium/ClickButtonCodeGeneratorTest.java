package org.mrr.generate.selenium;

import org.junit.Test;
import org.mrr.LocatorCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.mrr.selenium.ClickButtonCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class ClickButtonCodeGeneratorTest {

    @Test
    public void shouldGenerateCodeAsExpected() {
        final LocatorCodeGenerator locatorCodeGenerator = new LocatorCodeGeneratorStub();
        final TestStep testStep = new TestStep(CLICK_BUTTON, "submit");
        final ClickButtonCodeGenerator clickButtonCodeGenerator = new ClickButtonCodeGenerator(locatorCodeGenerator);
        assertThat(clickButtonCodeGenerator.generateCode(testStep)).isEqualTo("driver.findElement(By.id(\"submitHtmlId\")).click();");
    }
}