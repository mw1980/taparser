package org.mrr.reader;

/**
 * Exception thrown when the test case specification cannot be read.
 */
class TestSpecificationReaderException extends RuntimeException {

  public TestSpecificationReaderException(final String message) {
    super(message);
  }

  public TestSpecificationReaderException(final String message, final Throwable cause) {
    super(message, cause);
  }


}
