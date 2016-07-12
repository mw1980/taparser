package org.mrr.generator;

import org.mrr.AutomationStep;

/**
 * Selenium code generator for the actions of identificationType: "Click button myButton".
 */
public class ClickButtonCodeGenerator extends AbstractCodeGenerator {
  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public ClickButtonCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  /*
    Use this constructor only if you need to set a custom code identifier generator.
   */
  public ClickButtonCodeGenerator(final AutomationStep automationStep,
                                  final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    return "driver.findElement("
      + getCodeIdentifierGenerator().generate(getAutomationTarget()) + ").click();";
  }
}
