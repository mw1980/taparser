package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Implements the logic needed to parse a test step description to a collection of test steps.
 */
public interface TestStepParseLogic {
    /**
     * Parses the free text description of the test step and returns its corresponding TestStep object.
     */
    TestStep testStepForDescription(String description);
}