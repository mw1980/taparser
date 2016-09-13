package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.EDIT_TEXT;

/**
 * Selenium code generator for the operation "set value in edit description field".
 */
@Component
public class EditTextfieldCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    public EditTextfieldCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return "driver.findElement("
                + locatorCodeGenerator.identificationCodeFor(testStep.target())
                + ").sendKeys(\"" + testStep.value() + "\");";
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return EDIT_TEXT.equals(testStep.actionType());
    }
}
