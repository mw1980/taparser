package org.mrr.generator;

import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Selenium code generator for the actions of type: "Click button myButton".
 */
@Component
class ClickButtonCodeGenerator extends AbstractCodeGenerator {

    ClickButtonCodeGenerator(final TestStep testStep,
                             @Autowired final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
        super(testStep, controlIdCodeGenerator);
    }

    @Override
    public String generateCode() {
        return "driver.findElement("
                + getControlIdCodeGenerator().identificationFor(getAutomationTarget()) + ").click();";
    }
}
