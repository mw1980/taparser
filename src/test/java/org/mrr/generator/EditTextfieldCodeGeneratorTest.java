package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;

public class EditTextfieldCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateCodeAsExpected() {
    final EditTextfieldCodeGenerator editTextCodeGenerator = new EditTextfieldCodeGenerator(
      new AutomationStep(ActionType.EDIT_TEXT, "user", "newValue"),
      testCodeIdentifierGenerator);
    assertThat(editTextCodeGenerator.generateCode()).isEqualTo("driver.findElement(By.id(\"userNameHtmlId\")).sendKeys(\"newValue\");");
  }
}