package org.mrr;

import org.mrr.api.CodeFactory;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DefaultCodeActionLogic implements CodeActionLogic {

    private final CodeFactory factory;

    @Autowired
    public DefaultCodeActionLogic(final CodeFactory codeFactory) {
        this.factory = codeFactory;
    }

    @Override
    public String codeForAction(final Action action) {
        return factory
                .codeGenerationOperationFor(action)
                .codeFor(action);
    }
}
