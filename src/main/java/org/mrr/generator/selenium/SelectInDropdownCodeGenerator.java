package org.mrr.generator.selenium;


import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Test automation code generator for the operation: select in dropdown x value "y".
 */
@Component
public class SelectInDropdownCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    SelectInDropdownCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return "new Select (driver.findElement("
                + locatorCodeGenerator.identificationCodeFor(testStep.target())
                + ")).selectByVisibleText(\""
                + testStep.value()
                + "\");";
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return SELECT_IN_DROPDOWN.equals(testStep.actionType());
    }
}
