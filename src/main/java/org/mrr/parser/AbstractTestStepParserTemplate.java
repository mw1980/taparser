package org.mrr.parser;

import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import java.util.regex.Pattern;

/**
 * Abstract class, contains the methods to parse test case description and create
 * ActionSteps objects from free description test case description.
 */
abstract class AbstractTestStepParserTemplate implements TestStepParser {
    static final TestStepParser UNKNOWN = new TestStepParser() {
        @Override
        public TestStep parse(final String description) {
            return new TestStep(ActionType.UNKNOWN, "", "");
        }

        @Override
        public boolean canHandle(final String description) {
            return false;
        }
    };

    /**
     * The action method of the step parser.
     * Parses the action type, the action target and action values from test case description
     * and returns an TestStep object.
     *
     * @return test step object parsed from the test step description.
     */
    public TestStep parse(final String description) {
        validate(description);
        return new TestStep(
                parseActionType(),
                parseTarget(description),
                parseValue(description));
    }

    /**
     * Validates the free description of the test step.
     */
    protected abstract void validate(String description);

    /**
     * The method identifies the action type of the test step action from the test case description.
     *
     * @return the test case action type.
     */
    protected abstract ActionType parseActionType();

    /**
     * The method identifies the target of test step action from the current test case description.
     *
     * @return the test case action target as string.
     */
    protected abstract String parseTarget(String description);

    /**
     * The method returns the value that the test step action should set.
     * E.g. the value to be set in a description field.
     *
     * @return the value of the action
     */
    protected abstract String parseValue(String description);

    /**
     * Returns true if the test step description looks handlebar.
     * The method does not also validates the description.
     */
    public abstract boolean canHandle(String description);

    void performBasicValidation(final String regex, final String stepType, final String description) {
        if (!Pattern.matches(regex, description)) {
            throw new DescriptionNotParsableException(
                    String.format("The description: \"%s\" is not a valid %s step description.",
                            description,
                            stepType));
        }
    }
}
