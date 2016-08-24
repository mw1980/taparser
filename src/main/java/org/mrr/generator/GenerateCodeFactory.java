package org.mrr.generator;

import org.mrr.core.domain.TestStep;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Factory class for Code Generators.
 */
@Component
class GenerateCodeFactory implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    TestCaseCodeGenerator findGenerator(final TestStep testStep) {
        final Map<String, TestCaseCodeGenerator> generators = this.context.getBeansOfType(TestCaseCodeGenerator.class);
        for (final TestCaseCodeGenerator generator : generators.values()) {
            if (generator.canGenerate(testStep)) {
                return generator;
            }
        }
        throw new NoCodeGeneratorFoundException("No code generator registered for the test step: " + testStep);
    }
}
