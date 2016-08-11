package org.mrr.generator.selenium;

import org.junit.Ignore;
import org.junit.Test;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

public class SelectInDropdownCodeGeneratorTest {

    @Test
    @Ignore
    public void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
        final TestStep testStep = new TestStep(SELECT_IN_DROPDOWN, "withoutIdentifier");
        final SelectInDropdownCodeGenerator codeGenerator = new SelectInDropdownCodeGenerator(new IdCodeGeneratorStub());
        final String generateCode = codeGenerator.generateCode(testStep);
        assertTrue(generateCode.contains("Cannot find the control:"));
    }

    @Test
    public void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
        final TestStep testStep = new TestStep(SELECT_IN_DROPDOWN, "mydropdown", "ui option");
        final SelectInDropdownCodeGenerator codeGenerator = new SelectInDropdownCodeGenerator(new IdCodeGeneratorStub());
        final String code = codeGenerator.generateCode(testStep);
        assertThat(code).isEqualToIgnoringCase(
                "new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
    }
}