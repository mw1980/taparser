package org.mrr.core;

public class LoadControlsException extends RuntimeException {

  public LoadControlsException(final String message, final Throwable exception) {
    super(message, exception);
  }

  LoadControlsException(final String message) {
    super(message);
  }
}
