package org.mrr;

/**
 * Factory class to deliver the {@link ParseTestActionOperation} object to handle a given test action description.
 */
public interface ParseTestActionFactory {
    /**
     * Returns the {@link ParseTestActionOperation} that can handle the test description received as parameter.
     * If there is no {@link ParseTestActionOperation} available, it returns a not null dummy object.
     */
    ParseTestActionOperation parseOperationFromDescription(String description);
}
