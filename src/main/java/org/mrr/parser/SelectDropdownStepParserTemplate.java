package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Step parser for the actions of type select value in Dropdown.
 */
@Component
class SelectDropdownStepParserTemplate extends AbstractTestStepParserTemplate {
    @Override
    protected void validate(final String description) {
        final String regex = "Select in dropdown\\s\\w+\\svalue\\s\"[a-zA-Z0-9 ]+\"";
        super.performBasicValidation(regex, "select in dropdown", description);
    }

    @Override
    protected ActionType parseActionType() {
        return SELECT_IN_DROPDOWN;
    }

    @Override
    protected String parseTarget(final String description) {
        final String[] split = description.replaceAll("Select in dropdown ", "").split("value");
        return split[0].trim();
    }

    @Override
    protected String parseValue(final String description) {
        final String[] split = description.split("\"");
        return split[1];
    }

    @Override
    public boolean canHandle(final String description) {
        return description.
                trim().
                startsWith(SELECT_IN_DROPDOWN.description());
    }
}
