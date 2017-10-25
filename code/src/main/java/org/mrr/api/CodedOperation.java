package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 *  Base interface for classes that contain the automation code for a single operation, like: click a button, load a page.
 */
public interface CodedOperation {
    /**
     * Returns the test automation code for the {@link Action} object received as parameter.
     */
    String codeFor(Action action);

    /**
     * Returns true if it can provide the code for the {@link Action} object received as parameter.
     * Otherwise returns false.
     */
    boolean canHandle(Action action);
}
