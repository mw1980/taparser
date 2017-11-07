package org.mrr;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.CLICK_LINK;

/**
 * Parse operation class for the actions of type: "click button button_name".
 */
@Component
public class ParseClickButtonOperation extends AbstractParseActionOperationTemplate {

    //TODO: Separate the parse operations for click button and click link. Let the code generation operations generate
    //the same code, for both cases, if the test automation framework needs it.
    @Override
    protected void validate(final String description) {
        if (notAClickDescription("button", description)
                && (notAClickDescription("link", description))) {
            throw new DescriptionNotParsableException(
                    format("The action description '%s' cannot be parsed to a click button action.", description));
        }
    }

    private boolean notAClickDescription(final String elementType, final String description) {
        return !Pattern.matches(format("Click %s [a-z]+", elementType), description);
    }

    @Override
    protected ActionType actionType() {
        return CLICK_BUTTON;
    }

    @Override
    protected String targetFrom(final String description) {
        final String[] descriptionWords = description.split(" ");
    /*
     * position 0: click
     * position 1: button
     * position 2: buttonName
     */
        return descriptionWords[2];
    }

    @Override
    protected String valueFrom(final String description) {
        return "";
    }

    @Override
    public boolean canHandle(String description) {
        return description.trim().startsWith(CLICK_BUTTON.description())
                || description.trim().startsWith(CLICK_LINK.description());
    }
}
