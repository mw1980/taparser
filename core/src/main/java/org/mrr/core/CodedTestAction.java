package org.mrr.core;

/**
 * The class is a representation of a test action that contains also its automation code.
 */
public interface CodedTestAction extends ParsedTestAction {
    String code();
}
