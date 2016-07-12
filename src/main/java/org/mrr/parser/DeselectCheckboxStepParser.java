package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Parser class for the actions of identificationType: "deselect checkbox mycheckbox".
 */
public class DeselectCheckboxStepParser extends AbstractStepParser {

  /**
   * Standard constructor.
   * @param testStepDescription test step description, in this form: "deselect checkbox mycheckbox"
   */
  public DeselectCheckboxStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Deselect checkbox [a-zA-Z0-9]+", "deselect checkbox");
  }

  @Override
  protected String parseTarget() {
    final String[] splitDescription = getStepDescription().split(" ");
    return splitDescription[2];
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.DESELECT_CHECKBOX;
  }

  @Override
  protected String parseValue() {
    return "";
  }
}
