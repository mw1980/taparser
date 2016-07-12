package org.mrr.generator;

import org.mrr.AutomationStep;

/**
 * Selenium code generator for the actions of identificationType: "deselect checkbox mycheckbox".
 */
public class DeselectCheckboxCodeGenerator extends AbstractCodeGenerator {

  /**
   * Default Constructor.
   * @param automationStep The automation step to generate the test automation code for.
   */
  public DeselectCheckboxCodeGenerator(final AutomationStep automationStep) {
    super(automationStep);
  }

  /**
   * Use this constructor only id you need to specify a specific code identifier generator.
   */
  public DeselectCheckboxCodeGenerator(final AutomationStep automationStep,
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
