package org.mrr.core;

/**
 * Implements the logic needed to parse a test step description to a collection of AutomationSteps elements.
 */
public interface TestStepParserLogic {
    AutomationStep createAutomationStepForDescription(String description);
}
