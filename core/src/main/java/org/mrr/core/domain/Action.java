package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The java representation of a test action.
 * It contains:
 * - the action type, like: load page, edit description field, check;
 * - the target of an action, like: the value of a description field to be edited.
 * - the value of the action (optional), like: the value to set in the description field,
 * the url of the page to load, the value to check for in an edit field.
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Action {
    public static final Action EMPTY = new Action(ActionType.UNKNOWN, "", "");
    private final ActionType type;
    private final String target;
    private final String value;

    public Action(final ActionType type, final String target) {
        this(type, target, "");
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
