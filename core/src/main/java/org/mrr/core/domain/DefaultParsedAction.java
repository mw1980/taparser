package org.mrr.core.domain;

import lombok.Value;
import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.ParsedAction;

/**
 * A test action, that contains also the java representation of its description.
 */
@Value
public class DefaultParsedAction implements ParsedAction {
    private final DescribedAction origin;
    private final ParseActionLogic parseLogic;

    @Override
    public String description() {
        return origin.description();
    }

    @Override
    public Action action() {
        return parseLogic.actionFromDescription(origin);
    }
}
