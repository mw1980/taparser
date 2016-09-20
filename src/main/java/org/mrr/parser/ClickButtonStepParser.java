package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.CLICK_LINK;

/**
 * Parses class for the step: "click button buttonname".
 */
@Component
class ClickButtonStepParser extends AbstractTestStepParserTemplate {

    @Override
    protected void validate(final String description) {
        if (isNoClickDescription("button", description) &&
                (isNoClickDescription("link", description))) {
            throw new DescriptionNotParsableException(
                    format("The test step description '%s' cannot be parsed to a click button step.", description));
        }
    }

    private boolean isNoClickDescription(final String elementType, final String description) {
        return !Pattern.matches(format("Click %s [a-z]+", elementType), description);
    }

    @Override
    protected ActionType parseActionType() {
        return CLICK_BUTTON;
    }

    @Override
    protected String parseTarget(final String description) {
        final String[] descriptionWords = description.split(" ");
    /*
     * position 0: click
     * position 1: button
     * position 2: buttonName
     */
        return descriptionWords[2];
    }

    @Override
    protected String parseValue(final String description) {
        return "";
    }

    @Override
    public boolean canHandle(String description) {
        return isClickAction(description.trim());
    }

    private boolean isClickAction(final String description) {
        return description.startsWith(CLICK_BUTTON.description())
                || description.startsWith(CLICK_LINK.description());
    }
}
