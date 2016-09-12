package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Implements the logic needed to parse a test step description to a collection of test steps.
 */
public interface TestStepParserLogic {
    TestStep createTestStepForDescription(String description);
}
