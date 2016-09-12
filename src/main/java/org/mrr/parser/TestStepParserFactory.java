package org.mrr.parser;

/**
 * The interface contains the method(s) needed to retrieve a test step parser that corresponds to a test description.
 */
interface TestStepParserFactory {
    /**
     * Returns the test step parser that can parse the test step description received as parameter.
     * If there is no test parsers currently registered, that can parse the test description, that it returns a not null
     * dummy object.
     */
    TestStepParser deliverParserForDescription(String description);
}
