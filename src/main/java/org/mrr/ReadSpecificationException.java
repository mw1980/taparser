package org.mrr;

/**
 * Exception thrown when the test case specification cannot be read.
 */
public class ReadSpecificationException extends RuntimeException {

  public ReadSpecificationException(final String message) {
    super(message);
  }

  public ReadSpecificationException(final String message, final Throwable cause) {
    super(message, cause);
  }


}
