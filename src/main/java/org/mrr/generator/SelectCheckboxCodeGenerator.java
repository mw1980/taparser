package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
class SelectCheckboxCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param testStep The automation step to generate the test automation code for.
   */
  SelectCheckboxCodeGenerator(final TestStep testStep) {
    super(testStep);
  }

  SelectCheckboxCodeGenerator(final TestStep testStep,
                              final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
    super(testStep, controlIdCodeGenerator);
  }

  @Override
  public String generateCode() {
    final String checkboxIdCode = getControlIdCodeGenerator().identificationFor(getAutomationTarget());
    return "if (!driver.findElement(" + checkboxIdCode
      + ").isSelected()){driver.findElement(" + checkboxIdCode + ").click();}";
  }
}
