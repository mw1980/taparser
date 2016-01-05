package org.mrr.generator;

import org.mrr.AutomationStepBean;

import static org.mrr.generator.CodeIdentifierGenerator.*;

/**
 * Selenium code generator for the actions of type: "deselect checkbox mycheckbox".
 */
public class DeselectCheckboxCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public DeselectCheckboxCodeGenerator(final AutomationStepBean automationStep) {
    super(automationStep);
  }

  @Override
  public String generateCode() {
    final String identifierCodeForTarget = getIdentifierCodeFor(getAutomationTarget());
    return "if (driver.findElement(" + identifierCodeForTarget + ").isSelected()){driver.findElement(" + identifierCodeForTarget + ").click();}";
  }
}
