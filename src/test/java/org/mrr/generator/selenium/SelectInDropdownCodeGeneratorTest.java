package org.mrr.generator.selenium;

import org.junit.Test;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

public class SelectInDropdownCodeGeneratorTest {

    @Test(expected = LoadControlsException.class)
    public void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
        final LocatorCodeGenerator mockLocatorGenerator = mock(LocatorCodeGenerator.class);
        when(mockLocatorGenerator.identificationCodeFor("withoutIdentifier")).thenThrow(new LoadControlsException("control not found"));
        final SelectInDropdownCodeGenerator codeGenerator = new SelectInDropdownCodeGenerator(mockLocatorGenerator);
        codeGenerator.generateCode(new TestStep(SELECT_IN_DROPDOWN, "withoutIdentifier"));
    }

    @Test
    public void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
        final TestStep testStep = new TestStep(SELECT_IN_DROPDOWN, "mydropdown", "ui option");
        final SelectInDropdownCodeGenerator codeGenerator = new SelectInDropdownCodeGenerator(new LocatorCodeGeneratorStub());
        final String code = codeGenerator.generateCode(testStep);
        assertThat(code).isEqualToIgnoringCase(
                "new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
    }
}