package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Selenium code generator for the actions of type: "deselect checkbox mycheckbox".
 */
@Component
public class DeselectCheckboxCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    DeselectCheckboxCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String identificationCode = locatorCodeGenerator.identificationCodeFor(testStep.target());
        return "if (driver.findElement("
                + identificationCode
                + ").isSelected()){driver.findElement("
                + identificationCode
                + ").click();}";
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return DESELECT_CHECKBOX.equals(testStep.actionType());
    }
}
