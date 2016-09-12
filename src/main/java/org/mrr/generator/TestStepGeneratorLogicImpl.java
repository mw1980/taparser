package org.mrr.generator;

import org.mrr.core.TestStepGeneratorLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TestStepGeneratorLogicImpl implements TestStepGeneratorLogic {

    private final CodeGeneratorFactory generatorFactory;

    @Autowired
    public TestStepGeneratorLogicImpl(final CodeGeneratorFactory generatorFactory) {
        this.generatorFactory = generatorFactory;
    }

    @Override
    public String generateCode(final TestStep testStep) {
        final TestStepCodeGenerator generator = generatorFactory.deliverGenerator(testStep);
        return generator.generateCode(testStep);
    }
}
