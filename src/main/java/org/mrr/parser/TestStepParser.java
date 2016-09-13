package org.mrr.parser;

import org.mrr.core.domain.TestStep;

/**
 * General interface for parsing string test description to TestStep objects.
 */
interface TestStepParser {
    /**
     * The main functionality of a test step parser is to parse the description of a test step to its corresponding
     * TestStep object representation
     */
    TestStep parse(String description);

    /**
     * Specifies if the current parser understands the free test description received as parameter.
     */
    boolean canHandle(String description);
}
