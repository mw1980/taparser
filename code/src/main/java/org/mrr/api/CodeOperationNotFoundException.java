package org.mrr.api;

/**
 * The exception class covers the case: "a code operation is required, but not found".
 */
public class CodeOperationNotFoundException extends RuntimeException {
    public CodeOperationNotFoundException(final String message) {
        super(message);
    }
}
