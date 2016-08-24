package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;
import org.mrr.generator.TestCaseCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Selenium code generator for the actions of type: "deselect checkbox mycheckbox".
 */
@Component
public class DeselectCheckboxCodeGenerator implements TestCaseCodeGenerator {

    private final IdCodeGenerator idCodeGenerator;

    @Autowired
    DeselectCheckboxCodeGenerator(final IdCodeGenerator idCodeGenerator) {
        this.idCodeGenerator = idCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String identificationCode = idCodeGenerator.identificationCodeFor(testStep.target());
        return "if (driver.findElement("
                + identificationCode
                + ").isSelected()){driver.findElement("
                + identificationCode
                + ").click();}";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return DESELECT_CHECKBOX.equals(testStep.actionType());
    }
}
