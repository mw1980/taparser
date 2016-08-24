package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;
import org.mrr.generator.TestCaseCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

/**
 * Selenium code generator for the actions of type: "Click button myButton".
 */
@Component
public class ClickButtonCodeGenerator implements TestCaseCodeGenerator {

    private final IdCodeGenerator idCodeGenerator;

    @Autowired
    public ClickButtonCodeGenerator(final IdCodeGenerator idCodeGenerator) {
        this.idCodeGenerator = idCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return "driver.findElement("
                + idCodeGenerator.identificationCodeFor(testStep.target())
                + ").click();";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return CLICK_BUTTON.equals(testStep.actionType());
    }

}
