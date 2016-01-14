package org.mrr.generator;

import org.mrr.AutomationStepBean;

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

  /**
   * Use this constructor only id you need to specify a specific code identifier generator.
   */
  public DeselectCheckboxCodeGenerator(final AutomationStepBean automationStep,
                                       final CodeIdentifierGenerator codeIdentifierGenerator) {
    super(automationStep, codeIdentifierGenerator);
  }

  @Override
  public String generateCode() {
    final String targetIdCode = getCodeIdentifierGenerator().generate(getAutomationTarget());
    return "if (driver.findElement(" + targetIdCode
      + ").isSelected()){driver.findElement(" + targetIdCode + ").click();}";
  }
}
