package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.UiElementNotFoundException;

public class SelectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateExpectedCode(){
    final AutomationStepBean sampleAutomationBean = new AutomationStepBean(ActionType.SELECT_CHECKBOX, "agreecookies", null);
    final SelectCheckboxCodeGenerator codeGenerator = new SelectCheckboxCodeGenerator(sampleAutomationBean, testCodeIdentifierGenerator);
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(codeGenerator.generateCode()).isEqualTo(expectedCode);
  }

  @Test (expected = UiElementNotFoundException.class)
  public void whenParsingAutomationBeanWithUnknownTarget_shouldRaiseException(){
    final AutomationStepBean automationBeanWithUnknownTarget = new AutomationStepBean(ActionType.SELECT_CHECKBOX, "unknownTarget", null);
    new SelectCheckboxCodeGenerator(automationBeanWithUnknownTarget, testCodeIdentifierGenerator).generateCode();
  }
}