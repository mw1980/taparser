package org.mrr.core;

/**
 * A test action, that contains its human readable description.
 */
public interface DescribedAction {
    DescribedAction EMPTY = () -> "";

    String description();
}
