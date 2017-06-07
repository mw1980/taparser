package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.CodedTestAction;
import org.mrr.core.ParsedTestAction;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class DefaultCodedTestAction implements CodedTestAction {
    private final ParsedTestAction origin;
    private final CodeTestActionLogic codeLogic;

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
