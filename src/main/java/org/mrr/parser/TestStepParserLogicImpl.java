package org.mrr.parser;

import org.mrr.core.TestStepParserLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the interface TestStepParserLogic.
 */
@Component
class TestStepParserLogicImpl implements TestStepParserLogic {
    private final TestStepParserFactory parserFactory;

    @Autowired
    public TestStepParserLogicImpl(final TestStepParserFactory stepParserFactory) {
        this.parserFactory = stepParserFactory;
    }

    @Override
    public TestStep createTestStepForDescription(final String description) {
        final TestStepParser parser = parserFactory.deliverParserForDescription(description);
        return parser.parse(description);
    }
}
