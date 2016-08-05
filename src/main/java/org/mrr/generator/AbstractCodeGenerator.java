package org.mrr.generator;

import org.mrr.core.AutomationStep;

/**
 * Abstract class for Code Generators.
 */
public abstract class AbstractCodeGenerator {
  private final AutomationStep automationStep;
  private final CodeIdentifierGenerator codeIdentifierGenerator;

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  AbstractCodeGenerator(final AutomationStep automationStep) {
    this.automationStep = automationStep;
    this.codeIdentifierGenerator = new CodeIdentifierGenerator();
  }

  /**
   * Constructor for tests.
   * Allows to set also the custom code identifier generator.
   * @param automationStep The automation step to generate the test automation code for.
   * @param codeIdentifierGenerator The custom code identifier generator.
   */

  AbstractCodeGenerator(final AutomationStep automationStep,
                        final CodeIdentifierGenerator codeIdentifierGenerator) {
    this.automationStep = automationStep;
    this.codeIdentifierGenerator = codeIdentifierGenerator;
  }

  /**
   * The action method. It generates the test automation code for the current automation step.
   * @return the String representation of the test automation code for the current automation step.
   */
  public abstract String generateCode();

  String getAutomationTarget() {
    return automationStep.target();
  }

  String getAutomationValue() {
    return automationStep.value();
  }

  CodeIdentifierGenerator getCodeIdentifierGenerator() {
    return this.codeIdentifierGenerator;
  }
}
