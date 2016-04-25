package org.mrr;

/**
 * UI Elements Identification Types supported by the application.
 */
public enum IdentifiedBy {
  ID;

  public static IdentifiedBy forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentifiedBy.ID;
    }
    throw new UiElementNotFoundException("Unknown IdentifiedBy value for " + value);
  }
}
