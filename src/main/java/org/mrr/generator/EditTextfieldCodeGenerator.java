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

  public EditTextfieldCodeGenerator(final AutomationStepBean automationStep,
                                    final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    return "driver.findElement("
      + getCodeIdentifierGenerator().generate(getAutomationTarget())
      + ").sendKeys(\"" + getAutomationValue() + "\");";
  }
}
