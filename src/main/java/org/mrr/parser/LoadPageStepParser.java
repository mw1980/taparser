package org.mrr.parser;

import org.mrr.core.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.ActionType.LOAD_PAGE;

/**
 * The class contains methods to generate automation steps from plain text.
 */
@Component
public class LoadPageStepParser extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Load page\\s\\S+", "descriptionsAsText page", description);
    }

    @Override
    protected ActionType parseActionType() {
        return LOAD_PAGE;
    }

    @Override
    protected String parseTarget(final String description) {
        return "";
    }

    @Override
    protected String parseValue(final String description) {
        //Expected:
        // - on position 0 the action text: ""
        // - on position 1 the action target: "http://www.myWebPage.com"
        final String[] actionTokens = description.split(LOAD_PAGE.text() + " ");
        return actionTokens[1];
    }

    @Override
    public boolean canParse(final String description) {
        return description.trim().startsWith(LOAD_PAGE.text());
    }
}
