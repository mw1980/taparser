package org.mrr.generator;

import org.mrr.core.domain.TestStep;

/**
 * Code generator main interface.
 */
public interface TestStepCodeGenerator {
    /**
     * Generates the test automation code for the test step received as parameter.
     */
    String generateCode(TestStep testStep);

    /**
     * Returns true if it can generate the code the test step received as parameter.
     * Otherwise returns false.
     */
    boolean canGenerate(TestStep testStep);
}
