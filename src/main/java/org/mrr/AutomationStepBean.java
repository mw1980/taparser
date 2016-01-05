package org.mrr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * This class encapsulates the elements of an test automation step:
 * It contains:
 * - the action type, e.g.: load page, edit text field, check;
 * - the target of an action, e.g.: the id of an text field to be edited.
 * - the value of the action (optional), e.g. the value to set in the text field,
 * the url of the page to load, the value to check for in an edit field.
 */
public class AutomationStepBean {
  private final ActionType actionType;
  private final String target;
  private final String value;

  /**
   * The bean stores the elements of an automation step.
   * @param actionType the type of the action, e.g.: click button, edit textfield.
   * @param target the target of the action, e.g.: the button to be clicked.
   * @param value the value of the action, e.g.: the text to be written in textfield.
   */
  public AutomationStepBean(final ActionType actionType, final String target, final String value) {
    this.actionType = actionType;
    this.target = target;
    this.value = value;
  }

  public ActionType getActionType() {
    return actionType;
  }

  public String getTarget() {
    return target;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "AutomationStepBean{"
      + "actionType=" + actionType.getText()
      + ", target='" + target + '\''
      + ", value='" + value + '\''
      + '}';
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    final AutomationStepBean that = (AutomationStepBean) other;

    return new EqualsBuilder()
      .append(actionType, that.actionType)
      .append(target, that.target)
      .append(value, that.value)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(actionType)
      .append(target)
      .append(value)
      .toHashCode();
  }
}
