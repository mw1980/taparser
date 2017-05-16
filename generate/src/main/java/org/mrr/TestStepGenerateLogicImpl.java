package org.mrr;

import org.mrr.core.TestStepGenerateLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStepGenerateLogicImpl implements TestStepGenerateLogic {

    private final CodeGeneratorFactory generateFactory;

    @Autowired
    public TestStepGenerateLogicImpl(final CodeGeneratorFactory generatorFactory) {
        this.generateFactory = generatorFactory;
    }

    @Override
    public String automationCodeFor(final TestStep testStep) {
        return generateFactory.codeGeneratorForTestStep(testStep)
                .generateCode(testStep);
    }
}
