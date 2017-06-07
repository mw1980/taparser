package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 * Code generation main interface.
 */
public interface CodeTestActionOperation {
    /**
     * Generates the test automation code for the test step received as parameter.
     */
    String codeFor(Action action);

    /**
     * Returns true if it can generate the code the test step received as parameter.
     * Otherwise returns false.
     */
    boolean canHandle(Action action);
}
