package org.mrr.generator.selenium;


import org.mrr.core.domain.TestStep;
import org.mrr.generator.IdCodeGenerator;
import org.mrr.generator.TestCaseCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Test automation code generator for the operation: select in dropdown x value "y".
 */
@Component
public class SelectInDropdownCodeGenerator implements TestCaseCodeGenerator {

    private final IdCodeGenerator idCodeGenerator;

    @Autowired
    SelectInDropdownCodeGenerator(final IdCodeGenerator idCodeGenerator) {
        this.idCodeGenerator = idCodeGenerator;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        return "new Select (driver.findElement("
                + idCodeGenerator.identificationCodeFor(testStep.target())
                + ")).selectByVisibleText(\""
                + testStep.value()
                + "\");";
    }

    @Override
    public boolean canGenerate(final TestStep testStep) {
        return SELECT_IN_DROPDOWN.equals(testStep.actionType());
    }
}
