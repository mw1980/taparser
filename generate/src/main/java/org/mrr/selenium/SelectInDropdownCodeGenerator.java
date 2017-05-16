package org.mrr.selenium;


import org.mrr.LocatorCodeGenerator;
import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Test automation code generator for the operation: select in dropdown x value "y".
 */
@Component
public class SelectInDropdownCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    public SelectInDropdownCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return format("new Select (driver.findElement(%s)).selectByVisibleText(\"%s\");",
                locatorCodeGenerator.identificationCodeFor(testStep.target()), testStep.value());
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return SELECT_IN_DROPDOWN.equals(testStep.actionType());
    }
}