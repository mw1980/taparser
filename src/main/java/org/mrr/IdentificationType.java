package org.mrr;

import org.mrr.controls.api.ControlsPoolException;

/**
 * UI Elements Identification Types supported by the application.
 */
public enum IdentificationType {
  ID, UNKNOWN;

  public static IdentificationType forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentificationType.ID;
    }
    throw new ControlsPoolException("Unknown IdentificationType value for " + value);
  }
}
