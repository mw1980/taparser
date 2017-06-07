package org.mrr.core;

/**
 * A test action, that contains its human readable description.
 */
public interface TestActionDescription {
    TestActionDescription EMPTY = () -> "";

    String description();
}
