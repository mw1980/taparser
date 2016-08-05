package org.mrr.parser;

import org.mrr.core.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.ActionType.EDIT_TEXT;

/**
 * Parser class for the edit text field steps.
 */
@Component
public class EditTextfieldStepParserTemplate extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        final String regex = "Set in textfield\\s\\w+\\svalue\\s\"[a-zA-Z0-9_ ]+\"";
        super.performBasicValidation(regex, "edit text field", description);
    }

    @Override
    protected ActionType parseActionType() {
        return EDIT_TEXT;
    }

    @Override
    protected String parseTarget(final String description) {
        final String[] testCaseWords = description.split(" ");
        return testCaseWords[3];
    }

    @Override
    protected String parseValue(final String description) {
        final String[] actionTokens = description.split("value ");
        return actionTokens[1].replace("\"", "");
    }

    @Override
    public boolean canParse(String description) {
        return description.
                trim()
                .startsWith(EDIT_TEXT.text());
    }
}
