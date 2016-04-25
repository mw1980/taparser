package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;

public class ClickButtonCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateCodeAsExpected(){
    AutomationStep stepBean = new AutomationStep(ActionType.CLICK_BUTTON, "submit", "");
    final ClickButtonCodeGenerator clickButtonCodeGenerator = new ClickButtonCodeGenerator(stepBean, testCodeIdentifierGenerator);
    assertThat(clickButtonCodeGenerator.generateCode()).isEqualTo("driver.findElement(By.id(\"submitButtonId\")).click();");
  }
}