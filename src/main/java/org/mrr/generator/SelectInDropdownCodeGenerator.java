package org.mrr.generator;

import org.mrr.AutomationStepBean;

import static org.mrr.generator.CodeIdentifierGenerator.getIdentifierCodeFor;

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

  @Override
  public String generateCode() {
    return "new Select (driver.findElement(" + getIdentifierCodeFor(getAutomationTarget()) + ")).selectByVisibleText(\"" + getAutomationValue() + "\");";
  }
}
