package org.mrr.uielements;

/**
 * Exception thrown when calculating the enum value for a given literal/String value fails.
 */
public class UiElementNotFoundException extends RuntimeException {

  /**
   * Default Constructor.
   */
  public UiElementNotFoundException(final String message) {
    super(message);
  }
}
