package org.mrr;

/**
 * UI Elements Identification Types supported by the application.
 */
public enum IdentificationType {
  BY_ID;

  public static IdentificationType forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentificationType.BY_ID;
    }
    throw new IdentifierValueNotFoundException("Cannot calculate IdentificationType value for " + value);
  }
}
