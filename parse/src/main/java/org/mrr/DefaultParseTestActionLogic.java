package org.mrr;

import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.TestActionDescription;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultParseTestActionLogic implements ParseTestActionLogic {
    private final TestStepParserFactory factory;

    @Autowired
    public DefaultParseTestActionLogic(final TestStepParserFactory stepParserFactory) {
        this.factory = stepParserFactory;
    }

    @Override
    public Action actionFromDescription(final TestActionDescription description) {
        final ParseTestActionOperation parseOperation = factory.parserForDescription(description.description());
        return parseOperation.actionFrom(description.description());
    }
}
