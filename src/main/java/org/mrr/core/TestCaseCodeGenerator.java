package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Abstract class for Code Generators.
 */
public interface TestCaseCodeGenerator {
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
