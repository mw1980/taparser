package org.mrr;

/**
 * Exception thrown when calculating the enum value for a given literal/String value fails.
 */
public class IdentifierValueNotFoundException extends RuntimeException {

  /**
   * Default Constructor.
   */
  public IdentifierValueNotFoundException(final String message) {
    super(message);
  }
}
