package org.mrr.reader;

/**
 * Exception thrown when the test case specification cannot be read.
 */
class TestSpecificationReaderException extends RuntimeException {

  /**
   * Default Constructor.
   */
  public TestSpecificationReaderException(final String message) {
    super(message);
  }
}
