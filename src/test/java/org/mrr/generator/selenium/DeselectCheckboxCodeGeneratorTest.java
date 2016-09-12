package org.mrr.generator.selenium;

import org.junit.Test;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

public class DeselectCheckboxCodeGeneratorTest {

    @Test
    public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException() {
        final LocatorCodeGenerator locatorCodeGenerator = mock(LocatorCodeGenerator.class);
        when(locatorCodeGenerator.identificationCodeFor("notThere")).thenReturn("");
        final TestStep testStep = new TestStep(DESELECT_CHECKBOX, "notThere");
        new DeselectCheckboxCodeGenerator(locatorCodeGenerator).generateCode(testStep);
    }

    @Test
    public void shouldReturnExpectedSeleniumCode() {
        final LocatorCodeGenerator locatorCodeGenerator = new LocatorCodeGeneratorStub();
        final TestStep testStep = new TestStep(DESELECT_CHECKBOX, "agreeCookies");
        final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
        final DeselectCheckboxCodeGenerator generator = new DeselectCheckboxCodeGenerator(locatorCodeGenerator);
        assertThat(generator.generateCode(testStep)).isEqualTo(expectedCode);
    }
}