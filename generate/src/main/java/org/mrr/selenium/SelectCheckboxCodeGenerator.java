package org.mrr.selenium;

import org.mrr.LocatorCodeGenerator;
import org.mrr.TestStepCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
@Component
public class SelectCheckboxCodeGenerator implements TestStepCodeGenerator {

    private final LocatorCodeGenerator locatorCodeGenerator;

    @Autowired
    public SelectCheckboxCodeGenerator(final LocatorCodeGenerator locatorCodeGenerator) {
        this.locatorCodeGenerator = locatorCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String targetCode = identificationCode(testStep);
        return format("if (!driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                targetCode,
                targetCode);
    }

    private String identificationCode(final TestStep testStep) {
        return locatorCodeGenerator.identificationCodeFor(testStep.target());
    }

    @Override
    public boolean canHandle(final TestStep testStep) {
        return SELECT_CHECKBOX.equals(testStep.actionType());
    }
}
