package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.CodeGeneratorBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DeselectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

    @Test
    public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException() {
        final TestStep automationBean = new TestStep(ActionType.DESELECT_CHECKBOX, "notThere", null);
        new DeselectCheckboxCodeGenerator(automationBean, testControlIdCodeGenerator).generateCode();
    }

    @Test
    public void shouldReturnExpectedSeleniumCode() {
        final TestStep automationBean = new TestStep(ActionType.DESELECT_CHECKBOX, "agreecookies", null);
        final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
        final DeselectCheckboxCodeGenerator generator = new DeselectCheckboxCodeGenerator(automationBean, testControlIdCodeGenerator);
        assertThat(generator.generateCode()).isEqualTo(expectedCode);
    }
}