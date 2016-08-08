package org.mrr.parser;

import org.mrr.core.domain.AutomationStep;
import org.mrr.core.TestStepParserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the interface TestStepParserLogic.
 */
@Component
class TestStepParserLogicImpl implements TestStepParserLogic {
    private final TestStepParserAgent parserAgent;

    @Autowired
    public TestStepParserLogicImpl(final TestStepParserAgent stepParserAgent) {
        this.parserAgent = stepParserAgent;
    }

    @Override
    public AutomationStep createAutomationStepForDescription(final String description) {
        final TestStepParser parser = parserAgent.findParserForDescription(description);
        return parser.parse(description);
    }
}
