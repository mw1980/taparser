package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Parse operation for the actions of type "select value in dropdown".
 */
@Component
public class ParseSelectDropdownOperation extends AbstractParseActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        final String regex = "Select in dropdown\\s\\w+\\svalue\\s\"[a-zA-Z0-9 ]+\"";
        super.performBasicValidation(regex, "select in dropdown", description);
    }

    @Override
    protected ActionType actionType() {
        return SELECT_IN_DROPDOWN;
    }

    @Override
    protected String targetFrom(final String description) {
        final String[] split = description.replaceAll("Select in dropdown ", "").split("value");
        return split[0].trim();
    }

    @Override
    protected String valueFrom(final String description) {
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
