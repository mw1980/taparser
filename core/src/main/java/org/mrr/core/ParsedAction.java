package org.mrr.core;

import org.mrr.core.domain.Action;

/**
 * The representation of a test action, that contains also its java representation.
 */
public interface ParsedAction extends DescribedAction {
    /**
     * Returns the {@link Action} java representation of action's description.
     */
    Action action();
}
