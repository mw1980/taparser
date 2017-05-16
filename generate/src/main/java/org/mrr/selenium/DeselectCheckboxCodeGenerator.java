package org.mrr.selenium;

import org.mrr.LocatorCodeGenerator;
import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Selenium code generator for the actions of type: "deselect checkbox mycheckbox".
 */
@Component
public class DeselectCheckboxCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    public DeselectCheckboxCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String targetCode = identificationCodeFor(testStep);
        return format("if (driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                targetCode,
                targetCode);
    }

    private String identificationCodeFor(final TestStep testStep) {
        return locatorCodeGenerator.identificationCodeFor(testStep.target());
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return DESELECT_CHECKBOX.equals(testStep.actionType());
    }
}
