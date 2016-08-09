package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Abstract class for Code Generators.
 */
public abstract class AbstractCodeGenerator {
    private final TestStep testStep;
    private final GenerateIdCodeDelegateImpl controlIdCodeGenerator;

    /**
     * Constructor for tests.
     * Allows to set also the custom code identifier generator.
     *
     * @param testStep               The automation step to generate the test automation code for.
     * @param controlIdCodeGenerator The custom code identifier generator.
     */

    AbstractCodeGenerator(final TestStep testStep,
                          final GenerateIdCodeDelegateImpl controlIdCodeGenerator) {
        this.testStep = testStep;
        this.controlIdCodeGenerator = controlIdCodeGenerator;
    }

    /**
     * The action method. It generates the test automation code for the current automation step.
     *
     * @return the String representation of the test automation code for the current automation step.
     */
    public abstract String generateCode();

    String getAutomationTarget() {
        return testStep.target();
    }

    String getAutomationValue() {
        return testStep.value();
    }

    GenerateIdCodeDelegateImpl getControlIdCodeGenerator() {
        return this.controlIdCodeGenerator;
    }
}
