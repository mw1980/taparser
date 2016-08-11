package org.mrr.generator;

/**
 * The exception class covers the case: "a code generator is required, but not found".
 */
class NoCodeGeneratorFoundException extends RuntimeException {
  NoCodeGeneratorFoundException(final String message) {
    super(message);
  }
}
