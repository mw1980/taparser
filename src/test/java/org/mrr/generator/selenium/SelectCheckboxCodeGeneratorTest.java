package org.mrr.generator.selenium;

import org.junit.Ignore;
import org.junit.Test;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

public class SelectCheckboxCodeGeneratorTest {

    @Test
    public void shouldGenerateExpectedCode() {
        final SelectCheckboxCodeGenerator codeGenerator = new SelectCheckboxCodeGenerator(new IdCodeGeneratorStub());
        final TestStep testStep = new TestStep(SELECT_CHECKBOX, "agreeCookies");
        final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
        assertThat(codeGenerator.generateCode(testStep)).isEqualTo(expectedCode);
    }

    @Test
    @Ignore
    public void whenParsingAutomationBeanWithUnknownTarget_shouldRaiseException() {
        final TestStep testStep = new TestStep(SELECT_CHECKBOX, "unknownTarget");
        new SelectCheckboxCodeGenerator(new IdCodeGeneratorStub()).generateCode(testStep);
    }
}