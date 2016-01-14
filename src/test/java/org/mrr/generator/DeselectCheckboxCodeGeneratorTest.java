package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.IdentifierValueNotFoundException;

public class DeselectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test(expected = IdentifierValueNotFoundException.class)
  public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException() {
    final AutomationStepBean automationBean = new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "notThere", null);
    new DeselectCheckboxCodeGenerator(automationBean, testCodeIdentifierGenerator).generateCode();
  }

  @Test
  public void shouldReturnExpectedSeleniumCode() {
    final AutomationStepBean automationBean = new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "agreecookies", null);
    final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    final DeselectCheckboxCodeGenerator generator = new DeselectCheckboxCodeGenerator(automationBean, testCodeIdentifierGenerator);
    assertThat(generator.generateCode()).isEqualTo(expectedCode);
  }
}