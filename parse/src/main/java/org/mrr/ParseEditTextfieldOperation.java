package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.EDIT_TEXT;

/**
 * Parse operation class for edit fields actions.
 */
@Component
public class ParseEditTextfieldOperation extends AbstractParseActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        final String regex = "Set in textfield\\s\\w+\\svalue\\s\"[a-zA-Z0-9_ ]+\"";
        super.performBasicValidation(regex, "edit description field", description);
    }

    @Override
    protected ActionType actionType() {
        return EDIT_TEXT;
    }

    @Override
    protected String targetFrom(final String description) {
        final String[] words = description.split(" ");
        return words[3];
    }

    @Override
    protected String valueFrom(final String description) {
        final String[] actionTokens = description.split("value ");
        return actionTokens[1].replace("\"", "");
    }

    @Override
    public boolean canHandle(String description) {
        return description
                .trim()
                .startsWith(EDIT_TEXT.description());
    }
}
