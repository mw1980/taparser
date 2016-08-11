package org.mrr.generator.selenium;

import org.junit.Test;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

public class DeselectCheckboxCodeGeneratorTest {

    @Test
    public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException() {
        final IdCodeGenerator idCodeGenerator = mock(IdCodeGenerator.class);
        when(idCodeGenerator.identificationCodeFor("notThere")).thenReturn("");
        final TestStep testStep = new TestStep(DESELECT_CHECKBOX, "notThere");
        new DeselectCheckboxCodeGenerator(idCodeGenerator).generateCode(testStep);
    }

    @Test
    public void shouldReturnExpectedSeleniumCode() {
        final IdCodeGenerator idCodeGenerator = new IdCodeGeneratorStub();
        final TestStep testStep = new TestStep(DESELECT_CHECKBOX, "agreeCookies");
        final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
        final DeselectCheckboxCodeGenerator generator = new DeselectCheckboxCodeGenerator(idCodeGenerator);
        assertThat(generator.generateCode(testStep)).isEqualTo(expectedCode);
    }
}