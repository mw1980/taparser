package org.mrr.generator;

import org.mrr.core.domain.TestStep;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Factory class for code generators.
 */
@Component
class CodeGeneratorFactory implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    TestStepCodeGenerator deliverGenerator(final TestStep testStep) {
        final Map<String, TestStepCodeGenerator> generators = this.context.getBeansOfType(TestStepCodeGenerator.class);
        for (final TestStepCodeGenerator generator : generators.values()) {
            if (generator.canHandle(testStep)) {
                return generator;
            }
        }
        throw new NoCodeGeneratorFoundException("No code generator registered for the test step: " + testStep);
    }
}
