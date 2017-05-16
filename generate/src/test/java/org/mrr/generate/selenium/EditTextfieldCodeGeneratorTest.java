package org.mrr.generate.selenium;

import org.junit.Test;
import org.mrr.LocatorCodeGenerator;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.selenium.EditTextfieldCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class EditTextfieldCodeGeneratorTest {

    @Test
    public void shouldGenerateCodeAsExpected() {
        final LocatorCodeGenerator locatorCodeGenerator = new LocatorCodeGeneratorStub();
        final TestStep testStep = new TestStep(ActionType.EDIT_TEXT, "user", "newValue");
        final EditTextfieldCodeGenerator editTextCodeGenerator = new EditTextfieldCodeGenerator(locatorCodeGenerator);
        final String generateCode = editTextCodeGenerator.generateCode(testStep);
        assertThat(generateCode).isEqualTo("driver.findElement(By.id(\"userHtmlId\")).sendKeys(\"newValue\");");
    }
}