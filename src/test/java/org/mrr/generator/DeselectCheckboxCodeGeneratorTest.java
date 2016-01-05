package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;
import org.mrr.IdentifierValueNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class DeselectCheckboxCodeGeneratorTest {

  @Test (expected = IdentifierValueNotFoundException.class)
  public void whenGeneratingCodeForNotIdentifiableTarget_shouldThrowIdentifierValueNotFoundException(){
    final AutomationStepBean automationBean = new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "notThere", null);
    new DeselectCheckboxCodeGenerator(automationBean).generateCode();
  }

  @Test
  public void shouldReturnExpectedSeleniumCode(){
    final AutomationStepBean automationBean = new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "agreecookies", null);
    final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    final String generateCode = new DeselectCheckboxCodeGenerator(automationBean).generateCode();
    assertThat(generateCode).isEqualTo(expectedCode);
  }
}