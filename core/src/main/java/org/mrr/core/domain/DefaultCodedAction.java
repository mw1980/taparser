package org.mrr.core.domain;

import lombok.Value;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.CodedAction;
import org.mrr.core.ParsedAction;

@Value
public class DefaultCodedAction implements CodedAction {
    private final ParsedAction origin;
    private final CodeActionLogic codeLogic;

    @Override
    public String code() {
        return codeLogic.codeForAction(origin.action());
    }

    @Override
    public Action action() {
        return origin.action();
    }

    @Override
    public String description() {
        return origin.description();
    }
}
