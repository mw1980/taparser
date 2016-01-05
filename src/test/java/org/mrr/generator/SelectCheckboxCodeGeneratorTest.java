package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;
import org.mrr.IdentifierValueNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectCheckboxCodeGeneratorTest {

  @Test
  public void shouldGenerateExpectedCode(){
    final AutomationStepBean sampleAutomationBean = new AutomationStepBean(ActionType.SELECT_CHECKBOX, "agreecookies", null);
    final String generateCode = new SelectCheckboxCodeGenerator(sampleAutomationBean).generateCode();
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(generateCode).isEqualTo(expectedCode);
  }

  @Test (expected = IdentifierValueNotFoundException.class)
  public void whenParsingAutomationBeanWithUnknownTarget_shouldRaiseException(){
    final AutomationStepBean automationBeanWithUnknownTarget = new AutomationStepBean(ActionType.SELECT_CHECKBOX, "unknownTarget", null);
    new SelectCheckboxCodeGenerator(automationBeanWithUnknownTarget).generateCode();
  }
}