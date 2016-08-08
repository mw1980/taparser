package org.mrr.parser;

import org.mrr.core.AutomationStep;

/**
 * General interface for parsing string test description to AutomationStep objects.
 */
interface TestStepParser {
    /**
     * The main functionality of a test step parser is to parse the description of a test step to its corresponding
     * AutomationStep object representation
     */
    AutomationStep parse(String description);

    /**
     * Specifies if the current parser understands the free test description received as parameter.
     */
    boolean canParse(String description);
}
