package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 * Factory class to deliver the generate code operation needed to manage a test step.
 */
public interface CodeFactory {

    /**
     * Checks if any of the registered generate code operation can handle the given test step.
     *
     * @param step, the test step to generate code for
     * @return the generate code operation that can handle the given test step.
     * @throws CodeOperationNotFoundException, if among the registered generate operations there is none that can
     *                                         handle the test step received as parameter.
     */
    CodeTestActionOperation generateCodeOperationFor(Action step);
}
