package org.mrr.core.domain;

import org.mrr.core.LoadControlsException;

import static java.lang.String.format;

/**
 * The enum contains the identification criteria for a user interface element on the gui.
 * Example: byId, byName, byXPath.
 */
public enum IdentificationCriteria {
  ID, UNKNOWN;

  public static IdentificationCriteria forValue(final String value) {
    if ("id".equalsIgnoreCase(value)) {
      return ID;
    }
    throw new LoadControlsException(format("Cannot find a identification criteria for %s.", value));
  }
}
