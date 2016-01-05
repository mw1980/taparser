package org.mrr.parser;

/**
 * Runtime Exception thrown one tries to parse a malformed test step description.
 */
class UnparsableDescription extends RuntimeException {

  public UnparsableDescription(final String message) {
    super(message);
  }
}
