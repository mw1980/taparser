package org.mrr;

/**
 * The interface contains the method(s) needed to retrieve a test step parser that corresponds to a test description.
 */
public interface TestStepParserFactory {
    /**
     * Returns the test step parser that can parse the test step description received as parameter.
     * If there is no test parser currently registered, that can parse the test description, it returns a not null
     * dummy object.
     */
    ParseTestActionOperation parserForDescription(String description);
}
