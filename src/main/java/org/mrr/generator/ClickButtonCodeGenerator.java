package org.mrr.generator;

import org.mrr.core.domain.AutomationStep;

/**
 * Selenium code generator for the actions of type: "Click button myButton".
 */
class ClickButtonCodeGenerator extends AbstractCodeGenerator {
  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  ClickButtonCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  /*
    Use this constructor only if you need to set a custom code identifier generator.
   */
  ClickButtonCodeGenerator(final AutomationStep automationStep,
                                  final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    return "driver.findElement("
      + getCodeIdentifierGenerator().generate(getAutomationTarget()) + ").click();";
  }
}
