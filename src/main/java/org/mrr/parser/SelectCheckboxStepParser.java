package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Parser class for the action "Select checkbox".
 */
@Component
class SelectCheckboxStepParser extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Select checkbox \\w+", "select checkbox", description);
    }

    @Override
    protected ActionType parseActionType() {
        return SELECT_CHECKBOX;
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
    public boolean canHandle(final String description) {
        return description.
                trim().
                startsWith(SELECT_CHECKBOX.description());
    }
}
