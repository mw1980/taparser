package org.mrr.core.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * This class encapsulates the elements of an test automation step:
 * It contains:
 * - the action type, e.g.: descriptionsAsText page, edit text field, check;
 * - the target of an action, e.g.: the value of an text field to be edited.
 * - the value of the action (optional), e.g. the value to set in the text field,
 * the url of the page to descriptionsAsText, the value to check for in an edit field.
 */
@EqualsAndHashCode
@ToString
public class TestStep {
    private final ActionType type;
    private final String target;
    private final String value;

    /**
     * The bean stores the elements of an automation step.
     *
     * @param type   the type of the action, e.g.: click button, edit textfield.
     * @param target the target of the action, e.g.: the button to be clicked.
     * @param value  the value of the action, e.g.: the text to be written in textfield.
     */
    public TestStep(final ActionType type, final String target, final String value) {
        this.type = type;
        this.target = target;
        this.value = value;
    }

    public TestStep(final ActionType type, final String target) {
        this.type = type;
        this.target = target;
        this.value = "";
    }

    public ActionType actionType() {
        return type;
    }

    public String target() {
        return target;
    }

    public String value() {
        return value;
    }
}
