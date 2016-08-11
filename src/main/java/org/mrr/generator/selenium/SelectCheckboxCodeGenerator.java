package org.mrr.generator.selenium;

import org.mrr.core.TestCaseCodeGenerator;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
@Component
public class SelectCheckboxCodeGenerator implements TestCaseCodeGenerator {

    private final IdCodeGenerator idCodeGenerator;

    @Autowired
    SelectCheckboxCodeGenerator(final IdCodeGenerator idCodeGenerator) {
        this.idCodeGenerator = idCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final String checkboxIdCode = idCodeGenerator.identificationCodeFor(testStep.target());
        return "if (!driver.findElement("
                + checkboxIdCode
                + ").isSelected()){driver.findElement("
                + checkboxIdCode
                + ").click();}";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return SELECT_CHECKBOX.equals(testStep.actionType());
    }
}
