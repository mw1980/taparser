package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.UiElementNotFoundException;

public class DeselectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test(expected = UiElementNotFoundException.class)
  public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException() {
    final AutomationStep automationBean = new AutomationStep(ActionType.DESELECT_CHECKBOX, "notThere", null);
    new DeselectCheckboxCodeGenerator(automationBean, testCodeIdentifierGenerator).generateCode();
  }

  @Test
  public void shouldReturnExpectedSeleniumCode() {
    final AutomationStep automationBean = new AutomationStep(ActionType.DESELECT_CHECKBOX, "agreecookies", null);
    final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    final DeselectCheckboxCodeGenerator generator = new DeselectCheckboxCodeGenerator(automationBean, testCodeIdentifierGenerator);
    assertThat(generator.generateCode()).isEqualTo(expectedCode);
  }
}