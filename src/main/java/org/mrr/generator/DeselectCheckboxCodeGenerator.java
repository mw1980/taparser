package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Selenium code generator for the actions of type: "deselect checkbox mycheckbox".
 */
class DeselectCheckboxCodeGenerator extends AbstractCodeGenerator {

    DeselectCheckboxCodeGenerator(final TestStep testStep) {
        super(testStep);
    }

    /**
     * Use this constructor only id you need to specify a specific code identifier generator.
     */
    DeselectCheckboxCodeGenerator(final TestStep testStep,
                                  final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
        super(testStep, controlIdCodeGenerator);
    }

    @Override
    public String generateCode() {
        final String targetIdCode = getControlIdCodeGenerator().identificationFor(getAutomationTarget());
        return "if (driver.findElement(" + targetIdCode
                + ").isSelected()){driver.findElement(" + targetIdCode + ").click();}";
    }
}
