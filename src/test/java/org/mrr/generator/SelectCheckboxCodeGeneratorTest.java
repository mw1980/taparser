package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.CodeGeneratorBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectCheckboxCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateExpectedCode(){
    final TestStep sampleAutomationBean = new TestStep(ActionType.SELECT_CHECKBOX, "agreecookies", null);
    final SelectCheckboxCodeGenerator codeGenerator = new SelectCheckboxCodeGenerator(sampleAutomationBean, testControlIdCodeGenerator);
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(codeGenerator.generateCode()).isEqualTo(expectedCode);
  }

  @Test
  public void whenParsingAutomationBeanWithUnknownTarget_shouldRaiseException(){
    final TestStep automationBeanWithUnknownTarget = new TestStep(ActionType.SELECT_CHECKBOX, "unknownTarget", null);
    new SelectCheckboxCodeGenerator(automationBeanWithUnknownTarget, testControlIdCodeGenerator).generateCode();
  }
}