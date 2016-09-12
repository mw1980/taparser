package org.mrr.core.domain;

import org.mrr.core.LoadControlsException;

/**
 * The enum contains the user interface identification criteria supported by the application.
 */
public enum IdentificationCriteria {
  ID, UNKNOWN;

  public static IdentificationCriteria forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return ID;
    }
    throw new LoadControlsException("Unknown IdentificationCriteria value for " + value);
  }
}
