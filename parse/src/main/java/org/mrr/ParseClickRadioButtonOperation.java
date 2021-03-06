package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.SELECT_RADIO_BUTTON;

/**
 * Parse Operation class for the actions of type: "select radio button radioButtonOption".
 */
@Component
public class ParseClickRadioButtonOperation extends AbstractParseActionOperationTemplate {

    @Override
    protected void validate(final String description) {
        super.performBasicValidation("Select radio button\\s\\w+", "click radio button", description);
    }

    @Override
    protected ActionType actionType() {
        //TODO: refactor here. Parse operations should be unaware of test automation framework.
        //From selenium point of view, the selection of a radio button is a radio button click.
        return CLICK_BUTTON;
    }

    @Override
    protected String targetFrom(final String description) {
        final String[] splitDescription = description.split(" ");
        return splitDescription[3];
    }

    @Override
    protected String valueFrom(final String description) {
        return "";
    }

    @Override
    public boolean canHandle(final String description) {
        return description.trim()
                .startsWith(SELECT_RADIO_BUTTON.description());
    }
}
