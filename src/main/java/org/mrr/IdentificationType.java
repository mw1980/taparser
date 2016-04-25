package org.mrr;

import org.mrr.uielements.UiElementNotFoundException;

/**
 * UI Elements Identification Types supported by the application.
 */
public enum IdentificationType {
  ID;

  public static IdentificationType forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentificationType.ID;
    }
    throw new UiElementNotFoundException("Unknown IdentificationType value for " + value);
  }
}
