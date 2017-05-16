package org.mrr.selenium;

import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

/**
 * Selenium Code Generator for the "load page" action steps.
 */
@Component
public class LoadPageCodeGenerator implements TestStepCodeGenerator {

    @Override
    public String generateCode(final TestStep testStep) {
        return format("driver.get(\"%s\");", testStep.value());
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return LOAD_PAGE.equals(testStep.actionType());
    }
}
