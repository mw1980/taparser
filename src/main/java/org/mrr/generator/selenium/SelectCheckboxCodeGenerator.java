package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
@Component
public class SelectCheckboxCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    SelectCheckboxCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String checkboxIdCode = locatorCodeGenerator.identificationCodeFor(testStep.target());
        return "if (!driver.findElement("
                + checkboxIdCode
                + ").isSelected()){driver.findElement("
                + checkboxIdCode
                + ").click();}";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return SELECT_CHECKBOX.equals(testStep.actionType());
    }
}
