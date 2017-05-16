package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.EDIT_TEXT;

/**
 * Parser class for the edit description field steps.
 */
@Component
public class EditTextfieldStepParserTemplate extends AbstractTestStepParserTemplate {

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
        final String[] testCaseWords = description.split(" ");
        return testCaseWords[3];
    }

    @Override
    protected String valueFrom(final String description) {
        final String[] actionTokens = description.split("value ");
        return actionTokens[1].replace("\"", "");
    }

    @Override
    public boolean canHandle(String description) {
        return description.
                trim()
                .startsWith(EDIT_TEXT.description());
    }
}
