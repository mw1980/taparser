package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Parser class for the action "Select checkbox".
 */
public class SelectCheckboxStepParser extends AbstractStepParser {
  /**
   * Default constructor.
   * @param stepDescription description, in this form: "select checkbox checkboxname".
   */
  public SelectCheckboxStepParser(final String stepDescription) {
    super(stepDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Select checkbox \\w+", "select checkbox");
  }

  @Override
  protected String parseTarget() {
    String[] splitDescription = getStepDescription().split(" ");
    return splitDescription[2];
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.SELECT_CHECKBOX;
  }

  @Override
  protected String parseValue() {
    return "";
  }
}
