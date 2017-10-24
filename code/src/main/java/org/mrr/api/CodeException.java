package org.mrr.api;

/**
 * General exception class for the code generation operations.
 */
public class CodeException extends RuntimeException {

    public CodeException(final String message) {
        super(message);
    }
}
