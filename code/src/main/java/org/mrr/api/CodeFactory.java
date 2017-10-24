package org.mrr.api;

import org.mrr.core.domain.Action;

/**
 * Factory class that handles the code generation operations.
 */
public interface CodeFactory {

    /**
     * Checks if there is any registered {@link GenerateActionCodeOperation} that can handle the given {@link Action} object.
     *
     * @param action, the {@link Action} object to generate code for
     * @return the operation that can deliver the automation code for the given action.
     * @throws CodeOperationNotFoundException, if among the registered generate operations there is none that can
     *                                         handle the test action received as parameter.
     */
    GenerateActionCodeOperation codeGenerationOperationFor(Action action);
}
