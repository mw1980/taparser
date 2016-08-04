package org.mrr.core;

/**
 * The enum contains the user interface identification criteria supported by the application.
 */
public enum IdentificationCriteria {
  ID, UNKNOWN;

  public static IdentificationCriteria forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentificationCriteria.ID;
    }
    throw new LoadControlsException("Unknown IdentificationCriteria value for " + value);
  }
}
