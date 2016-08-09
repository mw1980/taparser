package org.mrr.generator;

import org.junit.Test;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;

public class EditTextfieldCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void shouldGenerateCodeAsExpected() {
    final EditTextfieldCodeGenerator editTextCodeGenerator = new EditTextfieldCodeGenerator(
            new TestStep(ActionType.EDIT_TEXT, "user", "newValue"),
            testControlIdCodeGenerator);
    assertThat(editTextCodeGenerator.generateCode()).isEqualTo("driver.findElement(By.id(\"userNameHtmlId\")).sendKeys(\"newValue\");");
  }
}