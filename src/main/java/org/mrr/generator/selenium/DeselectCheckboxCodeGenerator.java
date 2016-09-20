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
        return String.format("if (driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                identificationCode(testStep),
                identificationCode(testStep));
    }

    private String identificationCode(final TestStep testStep) {
        return locatorCodeGenerator.identificationCodeFor(testStep.target());
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return DESELECT_CHECKBOX.equals(testStep.actionType());
    }
}
