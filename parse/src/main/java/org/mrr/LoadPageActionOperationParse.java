package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.LOAD_PAGE;

/**
 * The class contains methods to generate test steps from plain description.
 */
@Component
public class LoadPageActionOperationParse extends AbstractParseTestActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Load page\\s\\S+", "loadDescriptions page", description);
    }

    @Override
    protected ActionType actionType() {
        return LOAD_PAGE;
    }

    @Override
    protected String targetFrom(final String description) {
        return "";
    }

    @Override
    protected String valueFrom(final String description) {
        //Expected:
        // - on position 0 the action description: ""
        // - on position 1 the action target: "http://www.myWebPage.com"
        final String[] actionTokens = description.split(LOAD_PAGE.description() + " ");
        return actionTokens[1];
    }

    @Override
    public boolean canHandle(final String description) {
        return description.trim().startsWith(LOAD_PAGE.description());
    }
}
