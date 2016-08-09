package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Selenium Code Generator for the Load Page action steps.
 */
class LoadPageCodeGenerator extends AbstractCodeGenerator {

  LoadPageCodeGenerator(final TestStep testStep) {
    super(testStep);
  }

  @Override
  public String generateCode() {
    return "driver.get(\"" + getAutomationValue() + "\");";
  }
}
