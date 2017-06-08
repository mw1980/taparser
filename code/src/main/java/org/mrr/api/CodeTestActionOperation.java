package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 *  Interface for the code generation operations.
 */
public interface CodeTestActionOperation {
    /**
     * Generates the test automation code for the {@link Action} object received as parameter.
     */
    String codeFor(Action action);

    /**
     * Returns true if it can provide the code for the {@link Action} object received as parameter.
     * Otherwise returns false.
     */
    boolean canHandle(Action action);
}
