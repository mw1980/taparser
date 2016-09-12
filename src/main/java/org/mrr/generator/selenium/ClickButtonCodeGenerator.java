package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.LocatorCodeGenerator;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return "driver.findElement("
                + locatorCodeGenerator.identificationCodeFor(testStep.target())
                + ").click();";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return CLICK_BUTTON.equals(testStep.actionType());
    }

}
