package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Base interface for classes that generate automation code, like selenium.
 */
public interface TestStepGeneratorLogic {
    /**
     * Generates the automation code for the test step object received as parameter.
     *
     * @return the string automation code (for instance selenium) for the given test step object.
     */
    String automationCodeFor(TestStep testStep);
}
