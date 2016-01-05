package org.mrr.generator;

import org.mrr.AutomationStepBean;

/**
 * Abstract class for Code Generators.
 */
public abstract class AbstractCodeGenerator {
  private final AutomationStepBean automationStep;

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  AbstractCodeGenerator(final AutomationStepBean automationStep) {
    this.automationStep = automationStep;
  }

  /**
   * The action method. It generates the test automation code for the current automation step.
   * @return the String representation of the test automation code for the current automation step.
   */
  public abstract String generateCode();

  AutomationStepBean getAutomationStep() {
    return automationStep;
  }

  String getAutomationTarget() {
    return automationStep.getTarget();
  }

  String getAutomationValue() {
    return automationStep.getValue();
  }
}
