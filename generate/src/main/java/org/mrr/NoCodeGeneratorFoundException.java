package org.mrr;

/**
 * The exception class covers the case: "a code generator is required, but not found".
 */
public class NoCodeGeneratorFoundException extends RuntimeException {
  NoCodeGeneratorFoundException(final String message) {
    super(message);
  }
}
