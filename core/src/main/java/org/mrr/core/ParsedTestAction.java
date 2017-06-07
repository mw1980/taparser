package org.mrr.core;

import org.mrr.core.domain.Action;

/**
 * The representation of a test action, that contains also its java representation.
 */
public interface ParsedTestAction extends TestActionDescription {
    Action action();
}
