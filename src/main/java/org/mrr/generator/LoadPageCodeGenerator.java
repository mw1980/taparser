package org.mrr.generator;

import org.mrr.core.domain.AutomationStep;

/**
 * Selenium Code Generator for the Load Page action steps.
 */
class LoadPageCodeGenerator extends AbstractCodeGenerator {

  LoadPageCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    return "driver.get(\"" + getAutomationValue() + "\");";
  }
}
