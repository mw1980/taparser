package org.mrr.generator;

import org.mrr.AutomationStep;

/**
 * Selenium Code Generator for the Load Page action steps.
 */
public class LoadPageCodeGenerator extends AbstractCodeGenerator {

  public LoadPageCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    return "driver.get(\"" + getAutomationValue() + "\");";
  }
}
