package org.mrr.generator;


import org.mrr.core.domain.TestStep;

/**
 * Test automation code generator for the operation: select in dropdown x value "y".
 */
class SelectInDropdownCodeGenerator extends AbstractCodeGenerator {
  /**
   * Default Constructor.
   * @param testStep The automation step to generate the test automation code for.
   */
  SelectInDropdownCodeGenerator(final TestStep testStep) {
    super(testStep);
  }

  SelectInDropdownCodeGenerator(final TestStep testStep,
                                final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
    super(testStep, controlIdCodeGenerator);
  }

  @Override
  public String generateCode() {
    return "new Select (driver.findElement("
            + getControlIdCodeGenerator().identificationFor(getAutomationTarget())
      + ")).selectByVisibleText(\"" + getAutomationValue() + "\");";
  }
}
