package org.mrr;

import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.TestActionDescription;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultParseTestActionLogic implements ParseTestActionLogic {
    private final ParseTestActionFactory factory;

    @Autowired
    public DefaultParseTestActionLogic(final ParseTestActionFactory stepParserFactory) {
        this.factory = stepParserFactory;
    }

    @Override
    public Action actionFromDescription(final TestActionDescription description) {
        final ParseTestActionOperation parseOperation = factory.parseOperationFromDescription(description.description());
        return parseOperation.actionFrom(description.description());
    }
}
