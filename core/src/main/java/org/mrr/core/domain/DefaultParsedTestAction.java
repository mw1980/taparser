package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.ParsedTestAction;
import org.mrr.core.TestActionDescription;

/**
 * A test action, that contains also the parsed description.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DefaultParsedTestAction implements ParsedTestAction {
    private final TestActionDescription origin;
    private final ParseTestActionLogic parseLogic;

    @Override
    public String description() {
        return origin.description();
    }

    @Override
    public Action action() {
        return parseLogic.actionFromDescription(origin);
    }
}
