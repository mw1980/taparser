package org.mrr.core.domain;

import org.mrr.core.LoadControlsException;

/**
 * The enum contains the way a user interface control is identified on the Gui.
 * Example: byId, byName, byXPath.
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
