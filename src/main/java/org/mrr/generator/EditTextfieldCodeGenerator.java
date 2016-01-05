package org.mrr.generator;

import static org.mrr.generator.CodeIdentifierGenerator.getIdentifierCodeFor;

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
    final String automationCodeForTarget = getIdentifierCodeFor(getAutomationTarget());
    return "driver.findElement(" + automationCodeForTarget
      + ").sendKeys(\"" + getAutomationValue() + "\");";
  }
}
