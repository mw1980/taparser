package org.mrr.generator;

import org.mrr.AutomationStepBean;

/**
 * Selenium Code Generator for the Load Page action steps.
 */
public class LoadPageCodeGenerator extends AbstractCodeGenerator {

  public LoadPageCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    return "driver.get(\"" + getAutomationValue() + "\");";
  }
}
