package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Implements the logic needed to parse a test step description to a collection of AutomationSteps elements.
 */
public interface TestStepParserLogic {
    TestStep createAutomationStepForDescription(String description);
}
