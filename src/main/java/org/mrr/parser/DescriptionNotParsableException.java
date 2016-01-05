package org.mrr.parser;

/**
 * Runtime Exception thrown one tries to parse a malformed test step description.
 */
class DescriptionNotParsableException extends RuntimeException {

  public DescriptionNotParsableException(final String message) {
    super(message);
  }
}
