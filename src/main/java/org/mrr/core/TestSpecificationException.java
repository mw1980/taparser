package org.mrr.core;

/**
 * Exception thrown when the test case specification cannot be loaded.
 */
public class TestSpecificationException extends RuntimeException {

    public TestSpecificationException(final String message) {
        super(message);
    }
}
