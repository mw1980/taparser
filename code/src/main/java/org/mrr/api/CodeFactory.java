package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 * Factory class to deliver the code operation needed to manage a test action.
 */
public interface CodeFactory {

    /**
     * Checks if any of the registered generate code operation can handle the given test step.
     *
     * @param action, the test action to generate code for
     * @return the operation that can deliver the automation code for the given action.
     * @throws CodeOperationNotFoundException, if among the registered generate operations there is none that can
     *                                         handle the test action received as parameter.
     */
    CodeTestActionOperation generateCodeOperationFor(Action action);
}
