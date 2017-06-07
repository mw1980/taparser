package org.mrr;

import org.mrr.api.CodeFactory;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DefaultCodeTestActionLogic implements CodeTestActionLogic {

    private final CodeFactory factory;

    @Autowired
    public DefaultCodeTestActionLogic(final CodeFactory generatorFactory) {
        this.factory = generatorFactory;
    }

    @Override
    public String codeForAction(final Action action) {
        return factory
                .generateCodeOperationFor(action)
                .codeFor(action);
    }
}
