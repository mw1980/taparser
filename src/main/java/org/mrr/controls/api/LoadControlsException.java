package org.mrr.controls.api;

public class LoadControlsException extends RuntimeException {

  public LoadControlsException(final String message, final Throwable exception) {
    super(message, exception);
  }

  public LoadControlsException(final String message) {
    super(message);
  }
}
