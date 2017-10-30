package org.mrr.core.domain;

/**
 * The class defines the supported user interface actions.
 */
//TODO: extract and extend the logic from the enum. Remove CLICK_LINK and SELECT_RADIO_BUTTON
// actions, since they are not needed.
public enum ActionType {
  LOAD_PAGE("Load page"),
  EDIT_TEXT("Set in textfield"),
  CLICK_BUTTON("Click button"),
  CLICK_LINK("Click link"),
  SELECT_IN_DROPDOWN("Select in dropdown"),
  SELECT_CHECKBOX("Select checkbox"),
  DESELECT_CHECKBOX("Deselect checkbox"),
  SELECT_RADIO_BUTTON("Select radio button"),
  UNKNOWN("");

  private final String description;

  ActionType(final String description) {
    this.description = description;
  }

  public final String description() {
    return description;
  }
}
