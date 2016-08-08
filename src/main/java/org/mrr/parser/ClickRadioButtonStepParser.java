package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.SELECT_RADIO_BUTTON;

/**
 * Parser class for the action steps in form: "select radio button radioButtonOption".
 */
@Component
class ClickRadioButtonStepParser extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Select radio button\\s\\w+", "click radio button", description);
    }

    @Override
    protected ActionType parseActionType() {
        //From selenium point of view, the selection of a radio button is a radio button click.
        return CLICK_BUTTON;
    }

    @Override
    protected String parseTarget(final String description) {
        final String[] splitDescription = description.split(" ");
        return splitDescription[3];

    }

    @Override
    protected String parseValue(final String description) {
        return "";
    }

    @Override
    public boolean canParse(final String description) {
        return description.trim()
                .startsWith(SELECT_RADIO_BUTTON.text());
    }
}
