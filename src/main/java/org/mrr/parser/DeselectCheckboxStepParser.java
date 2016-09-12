package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Parser class for the actions of type: "deselect checkbox mycheckbox".
 */
@Component
class DeselectCheckboxStepParser extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Deselect checkbox [a-zA-Z0-9]+", "deselect checkbox", description);
    }

    @Override
    protected ActionType parseActionType() {
        return DESELECT_CHECKBOX;
    }

    @Override
    protected String parseTarget(final String description) {
        final String[] splitDescription = description.split(" ");
        return splitDescription[2];
    }

    @Override
    protected String parseValue(final String description) {
        return "";
    }

    @Override
    public boolean canParse(final String description) {
        return description.trim().
                startsWith(DESELECT_CHECKBOX.description());
    }
}
