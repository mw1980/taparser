package org.mrr;

/**
 * UI Elements Identification Types supported by the application.
 */
public enum IdentificationType {
  BY_ID;

  /**
   * The method delivers an IdentificationType object for a string value.
   * @param value the string description of the IdentificationType.
   * @return The IdentificationType for the given parameter value.
   */
  public static IdentificationType forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return IdentificationType.BY_ID;
    }
    throw new IdentifierValueNotFoundException("Unknown IdentificationType value for " + value);
  }
}
