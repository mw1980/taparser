package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Parse operation class for the actions of type "Select checkbox".
 */
@Component
public class ParseSelectCheckboxOperation extends AbstractParseActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Select checkbox \\w+", "select checkbox", description);
    }

    @Override
    protected ActionType actionType() {
        return SELECT_CHECKBOX;
    }

    @Override
    protected String targetFrom(final String description) {
        final String[] splitDescription = description.split(" ");
        return splitDescription[2];
    }

    @Override
    protected String valueFrom(final String description) {
        return "";
    }

    @Override
    public boolean canHandle(final String description) {
        return description
                .trim()
                .startsWith(SELECT_CHECKBOX.description());
    }
}
