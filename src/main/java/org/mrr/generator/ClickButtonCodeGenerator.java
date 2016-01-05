package org.mrr.generator;

import static org.mrr.generator.CodeIdentifierGenerator.getIdentifierCodeFor;

import org.mrr.AutomationStepBean;

/**
 * Selenium code generator for the actions of type: "Click button myButton".
 */
public class ClickButtonCodeGenerator extends AbstractCodeGenerator {
  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public ClickButtonCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    return "driver.findElement(" + getIdentifierCodeFor(getAutomationTarget()) + ").click();";
  }
}
