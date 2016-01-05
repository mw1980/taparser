package org.mrr;

/**
 * User interface supported action types.
 */
public enum ActionType {
  LOAD_PAGE("Load page"),
  EDIT_TEXT("Set in textfield"),
  CLICK_BUTTON("Click button"),
  CLICK_LINK("Click link"),
  SELECT_IN_DROPDOWN("Select in dropdown"),
  SELECT_CHECKBOX("Select checkbox"),
  DESELECT_CHECKBOX("Deselect checkbox"),
  SELECT_RADIO_BUTTON("Select radio button");

  private final String actionText;

  ActionType(final String actionText) {
    this.actionText = actionText;
  }

  public final String getText() {
    return actionText;
  }
}
