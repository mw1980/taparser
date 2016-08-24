package org.mrr.generator.selenium;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;
import org.mrr.generator.TestCaseCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.EDIT_TEXT;

/**
 * Selenium code generator for the operation "set value in edit text field".
 */
@Component
public class EditTextfieldCodeGenerator implements TestCaseCodeGenerator {

    private final IdCodeGenerator idCodeGenerator;

    @Autowired
    public EditTextfieldCodeGenerator(final IdCodeGenerator idCodeGenerator) {
        this.idCodeGenerator = idCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return "driver.findElement("
                + idCodeGenerator.identificationCodeFor(testStep.target())
                + ").sendKeys(\"" + testStep.value() + "\");";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return EDIT_TEXT.equals(testStep.actionType());
    }
}
