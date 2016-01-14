package org.mrr.generator;

import org.mrr.AutomationStepBean;

/**
 * Selenium Code Generator for the operation "set value in edit text field".
 */
public class EditTextfieldCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public EditTextfieldCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    return "driver.findElement("
      + getCodeIdentifierGenerator().generate(getAutomationTarget())
      + ").sendKeys(\"" + getAutomationValue() + "\");";
  }
}
