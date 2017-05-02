package org.mrr.parser;

import org.mrr.core.TestStepParserLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TestStepParserLogicImpl implements TestStepParserLogic {
    private final TestStepParserFactory parserFactory;

    @Autowired
    public TestStepParserLogicImpl(final TestStepParserFactory stepParserFactory) {
        this.parserFactory = stepParserFactory;
    }

    @Override
    public TestStep testStepForDescription(final String description) {
        final TestStepParser parser = parserFactory.parserForDescription(description);
        return parser.parse(description);
    }
}
