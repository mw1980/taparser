package org.mrr.generator;


import org.mrr.AutomationStepBean;

/**
 * Test automation code generator for the operation: select in dropdown x value "y".
 */
public class SelectInDropdownCodeGenerator extends AbstractCodeGenerator {
  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public SelectInDropdownCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  public SelectInDropdownCodeGenerator(final AutomationStepBean automationStep,
                                       final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    return "new Select (driver.findElement("
      + getCodeIdentifierGenerator().generate(getAutomationTarget())
      + ")).selectByVisibleText(\"" + getAutomationValue() + "\");";
  }
}
