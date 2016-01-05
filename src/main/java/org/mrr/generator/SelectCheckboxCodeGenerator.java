package org.mrr.generator;

import org.mrr.AutomationStepBean;

import static org.mrr.generator.CodeIdentifierGenerator.*;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
public class SelectCheckboxCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public SelectCheckboxCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    final String checkboxIdentifier = getIdentifierCodeFor(getAutomationTarget());
    return "if (!driver.findElement(" + checkboxIdentifier + ").isSelected()){driver.findElement(" + checkboxIdentifier + ").click();}";
  }
}
