package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Selenium Code Generator for the operation "set value in edit text field".
 */
class EditTextfieldCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param testStep The automation step to generate the test automation code for.
   */
  EditTextfieldCodeGenerator(final TestStep testStep) {
    super(testStep);
  }

  EditTextfieldCodeGenerator(final TestStep testStep,
                             final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
    super(testStep, controlIdCodeGenerator);
  }

  @Override
  public String generateCode() {
    return "driver.findElement("
            + getControlIdCodeGenerator().identificationFor(getAutomationTarget())
      + ").sendKeys(\"" + getAutomationValue() + "\");";
  }
}
