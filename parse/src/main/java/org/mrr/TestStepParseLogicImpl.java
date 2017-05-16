package org.mrr;

import org.mrr.core.TestStepParseLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStepParseLogicImpl implements TestStepParseLogic {
    private final TestStepParserFactory parserFactory;

    @Autowired
    public TestStepParseLogicImpl(final TestStepParserFactory stepParserFactory) {
        this.parserFactory = stepParserFactory;
    }

    @Override
    public TestStep testStepForDescription(final String description) {
        final TestStepParser parser = parserFactory.parserForDescription(description);
        return parser.parse(description);
    }
}
