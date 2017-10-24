package org.mrr;

import org.mrr.core.domain.Action;

/**
 * General interface for parsing string test description to {@link Action} objects.
 */
public interface ParseActionOperation {
    /**
     * The main functionality of a test step parser is to parse the description of a test step to its corresponding
     * Action object representation
     */
    Action actionFrom(String description);

    /**
     * Specifies if the current parser understands the free test description received as parameter.
     */
    boolean canHandle(String description);
}
