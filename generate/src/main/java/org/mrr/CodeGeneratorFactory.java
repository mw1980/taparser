package org.mrr;

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
public class CodeGeneratorFactory implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public TestStepCodeGenerator codeGeneratorForTestStep(final TestStep testStep) {
        final Map<String, TestStepCodeGenerator> generators = this.context.getBeansOfType(TestStepCodeGenerator.class);
        return generators.values().stream()
                .filter(generator -> generator.canHandle(testStep))
                .findFirst()
                .orElseThrow(() -> new NoCodeGeneratorFoundException("No code generator registered for the test step: " + testStep));
    }
}