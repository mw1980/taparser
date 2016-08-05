package org.mrr.generator;

import org.mrr.core.AutomationStep;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
public class SelectCheckboxCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public SelectCheckboxCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  public SelectCheckboxCodeGenerator(final AutomationStep automationStep,
                                     final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    final String checkboxIdCode = getCodeIdentifierGenerator().generate(getAutomationTarget());
    return "if (!driver.findElement(" + checkboxIdCode
      + ").isSelected()){driver.findElement(" + checkboxIdCode + ").click();}";
  }
}
