package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.TestStepCodeGenerator;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.LOAD_PAGE;

/**
 * Selenium Code Generator for the Load Page action steps.
 */
@Component
public class LoadPageCodeGenerator implements TestStepCodeGenerator {

    @Override
    public String generateCode(final TestStep testStep) {
        return "driver.get(\""
                + testStep.value()
                + "\");";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return LOAD_PAGE.equals(testStep.actionType());
    }
}
