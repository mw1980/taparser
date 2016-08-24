package org.mrr.generator;

import org.mrr.core.TestCaseGeneratorLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Code generate implementation for the selenium.
 */
@Component
class TestCaseGeneratorLogicImpl implements TestCaseGeneratorLogic {

    private final GenerateCodeFactory generatorFactory;

    @Autowired
    public TestCaseGeneratorLogicImpl(final GenerateCodeFactory generatorFactory) {
        this.generatorFactory = generatorFactory;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final TestCaseCodeGenerator generator = generatorFactory.findGenerator(testStep);
        return generator.generateCode(testStep);
    }
}
