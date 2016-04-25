package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.uielements.UiElementNotFoundException;

public class SelectInDropdownCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test(expected = UiElementNotFoundException.class)
  public void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
    final AutomationStep beanWithoutIdentifier = new AutomationStep(ActionType.SELECT_IN_DROPDOWN, "withoutIdentifier", "");
    new SelectInDropdownCodeGenerator(beanWithoutIdentifier, testCodeIdentifierGenerator).generateCode();
  }

  @Test
  public void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
    final AutomationStep selectDropdownBean = new AutomationStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option");
    final String generateCode = new SelectInDropdownCodeGenerator(selectDropdownBean, testCodeIdentifierGenerator).generateCode();
    assertThat(generateCode).isEqualToIgnoringCase("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
  }
}