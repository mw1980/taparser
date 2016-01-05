package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.assertj.core.api.Assertions.assertThat;

public class EditTextfieldCodeGeneratorTest {

  @Test
  public void shouldGenerateCodeAsExpected() {
    final EditTextfieldCodeGenerator editTextCodeGenerator = new EditTextfieldCodeGenerator(new AutomationStepBean(ActionType.EDIT_TEXT, "user", "newValue"));
    assertThat(editTextCodeGenerator.generateCode()).isEqualTo("driver.findElement(By.id(\"userNameHtmlId\")).sendKeys(\"newValue\");");
  }
}