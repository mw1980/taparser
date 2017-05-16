package org.mrr.selenium;

import org.mrr.LocatorCodeGenerator;
import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

/**
 * Selenium code generator for the actions of type: "Click button myButton".
 */
@Component
public class ClickButtonCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    public ClickButtonCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return format("driver.findElement(%s).click();",
                locatorCodeGenerator.identificationCodeFor(testStep.target()));
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return CLICK_BUTTON.equals(testStep.actionType());
    }
}