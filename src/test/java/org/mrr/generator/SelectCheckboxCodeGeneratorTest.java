package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.UiElementNotFoundException;

public class SelectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateExpectedCode(){
    final AutomationStep sampleAutomationBean = new AutomationStep(ActionType.SELECT_CHECKBOX, "agreecookies", null);
    final SelectCheckboxCodeGenerator codeGenerator = new SelectCheckboxCodeGenerator(sampleAutomationBean, testCodeIdentifierGenerator);
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(codeGenerator.generateCode()).isEqualTo(expectedCode);
  }

  @Test (expected = UiElementNotFoundException.class)
  public void whenParsingAutomationBeanWithUnknownTarget_shouldRaiseException(){
    final AutomationStep automationBeanWithUnknownTarget = new AutomationStep(ActionType.SELECT_CHECKBOX, "unknownTarget", null);
    new SelectCheckboxCodeGenerator(automationBeanWithUnknownTarget, testCodeIdentifierGenerator).generateCode();
  }
}