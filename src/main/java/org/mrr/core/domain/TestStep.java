package org.mrr.core.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The java representation of a test step.
 * It contains:
 * - the action type, like: load page, edit description field, check;
 * - the target of an action, like: the value of an description field to be edited.
 * - the value of the action (optional), like: the value to set in the description field,
 * the url of the page to load, the value to check for in an edit field.
 */
@EqualsAndHashCode
@ToString
public class TestStep {
    private final ActionType type;
    private final String target;
    private final String value;

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
