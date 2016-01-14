package org.mrr.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.IdentifierValueNotFoundException;

public class SelectInDropdownCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test(expected = IdentifierValueNotFoundException.class)
  public void whenGeneratingCodeForUiElementWithoutIdentifier_shouldThrowIdentifierValueNotFoundException() {
    final AutomationStepBean beanWithoutIdentifier = new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "withoutIdentifier", "");
    new SelectInDropdownCodeGenerator(beanWithoutIdentifier, testCodeIdentifierGenerator).generateCode();
  }

  @Test
  public void whenGeneratingCodeForSelectDropdownOperation_shouldGenerateTheExpectedCode() {
    final AutomationStepBean selectDropdownBean = new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option");
    final String generateCode = new SelectInDropdownCodeGenerator(selectDropdownBean, testCodeIdentifierGenerator).generateCode();
    assertThat(generateCode).isEqualToIgnoringCase("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"ui option\");");
  }
}