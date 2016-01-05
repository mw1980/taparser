package org.mrr.generator;

/**
 * The exception class covers the case: "a code generator is required, but not found".
 */
class CodeGeneratorNotIdentifiedException extends RuntimeException {
  public CodeGeneratorNotIdentifiedException(final String message) {
    super(message);
  }
}
