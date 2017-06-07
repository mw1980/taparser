package org.mrr.core;

import org.mrr.core.domain.Action;

/**
 * Base interface for classes that generate automation code, like selenium.
 */
public interface CodeTestActionLogic {
    /**
     * Generates the automation code for the test action object received as parameter.
     *
     * @return the automation code (for instance selenium) for the given test action object.
     */
    String codeForAction(Action action);
}
