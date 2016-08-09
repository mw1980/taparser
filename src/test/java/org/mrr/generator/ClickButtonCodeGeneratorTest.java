package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.CodeGeneratorBaseTest;

public class ClickButtonCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateCodeAsExpected(){
    TestStep stepBean = new TestStep(ActionType.CLICK_BUTTON, "submit", "");
    final ClickButtonCodeGenerator clickButtonCodeGenerator = new ClickButtonCodeGenerator(stepBean, testControlIdCodeGenerator);
    assertThat(clickButtonCodeGenerator.generateCode()).isEqualTo("driver.findElement(By.id(\"submitButtonId\")).click();");
  }
}