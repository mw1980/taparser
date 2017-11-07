package org.mrr;

import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultParseActionLogic implements ParseActionLogic {
    private final ParseActionFactory factory;

    @Autowired
    public DefaultParseActionLogic(final ParseActionFactory parseActionFactory) {
        this.factory = parseActionFactory;
    }

    @Override
    public Action actionFromDescription(final DescribedAction action) {
        final String description = action.description();
        return factory
                .parseOperationForDescription(description)
                .actionFor(description);
    }
}
