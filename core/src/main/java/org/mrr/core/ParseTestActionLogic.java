package org.mrr.core;

import org.mrr.core.domain.Action;

/**
 * Implements the logic needed to parse a {@link TestActionDescription}.
 */
public interface ParseTestActionLogic {
    /**
     * Parses the free text description of the test step and returns its corresponding {@link Action} object.
     */
    Action actionFromDescription(TestActionDescription description);
}
