package org.mrr.selenium;

import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.domain.Action;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

/**
 * Selenium code generator for the "load page" action steps.
 */
@Component
public class CodeLoadPageOperation implements CodeTestActionOperation {

    @Override
    public String codeFor(final Action action) {
        return format("driver.get(\"%s\");", action.value());
    }

    @Override
    public boolean canHandle(final Action action) {
        return LOAD_PAGE == action.actionType();
    }
}
