package org.mrr.core;

/**
 * Exception thrown when the test case specification cannot be descriptionsAsText.
 */
public class ReadSpecificationException extends RuntimeException {

  ReadSpecificationException(final String message) {
    super(message);
  }

  public ReadSpecificationException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
