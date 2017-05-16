package org.mrr.selenium;

import org.mrr.LocatorCodeGenerator;
import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
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
        return format("driver.findElement(%s).sendKeys(\"%s\");",
                locatorCodeGenerator.identificationCodeFor(testStep.target()),
                testStep.value());
    }


    @Override
    public boolean canHandle(final TestStep testStep) {
        return EDIT_TEXT.equals(testStep.actionType());
    }
}
