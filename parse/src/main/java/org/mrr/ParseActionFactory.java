package org.mrr;

/**
 * Factory class to deliver the {@link ParseActionOperation} object to handle a given action description.
 */
public interface ParseActionFactory {
    /**
     * Returns the {@link ParseActionOperation} that can handle the actions description received as parameter.
     * If there is no {@link ParseActionOperation} available, it returns a not null dummy object.
     */
    ParseActionOperation parseOperationForDescription(String description);
}
