package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonCodeGeneratorTest {

  @Test
  public void shouldGenerateCodeAsExpected(){
    AutomationStepBean stepBean = new AutomationStepBean(ActionType.CLICK_BUTTON, "submit", "");
    //TODO springify it. The actual implementation reads the identifiers from the production csv file :(
    String generatedCode = new ClickButtonCodeGenerator(stepBean).generateCode();
    assertThat(generatedCode).isEqualTo("driver.findElement(By.id(\"submitButtonId\")).click();");
  }
}