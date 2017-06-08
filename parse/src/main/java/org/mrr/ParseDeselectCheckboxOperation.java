package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Parse operation class for the actions of type: "deselect checkbox mycheckbox".
 */
@Component
public class ParseDeselectCheckboxOperation extends AbstractParseTestActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Deselect checkbox [a-zA-Z0-9]+", "deselect checkbox", description);
    }

    @Override
    protected ActionType actionType() {
        return DESELECT_CHECKBOX;
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
        return description.trim().
                startsWith(DESELECT_CHECKBOX.description());
    }
}
