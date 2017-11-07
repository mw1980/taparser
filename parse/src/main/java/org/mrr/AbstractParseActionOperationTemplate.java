package org.mrr;

import org.mrr.core.DescribedAction;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import java.util.regex.Pattern;

import static java.lang.String.format;

/**
 * Abstract class, contains the methods to parse a {@link DescribedAction} description and create
 * {@link Action} objects from action's description.
 */
public abstract class AbstractParseActionOperationTemplate implements ParseActionOperation {

    /**
     * The method delivers the {@link Action} object for an action description.
     *
     * @return {@link Action} object parsed from the action's description.
     */
    public Action actionFor(final String description) {
        validate(description);
        return new Action(
                actionType(),
                targetFrom(description),
                valueFrom(description));
    }

    /**
     * Checks if the action description is valid.
     */
    protected abstract void validate(String description);

    /**
     * The method identifies the action type of from the action's description.
     *
     * @return the test case action type.
     */
    protected abstract ActionType actionType();

    /**
     * The method identifies the target of action from its description.
     *
     * @return the actions target as string.
     */
    protected abstract String targetFrom(String description);

    /**
     * The method returns the value that the action should set.
     * E.g. the value to be set in a description field.
     *
     * @return the value of the action
     */
    protected abstract String valueFrom(String description);

    /**
     * Returns true if the test actions description looks handlebar.
     * The method does not also validates the description.
     */
    public abstract boolean canHandle(String description);

    void performBasicValidation(final String regex, final String type, final String description) {
        if (!Pattern.matches(regex, description)) {
            throw new DescriptionNotParsableException(
                    format("The description: \"%s\" is not a valid %s action description.",
                            description, type));
        }
    }
}
