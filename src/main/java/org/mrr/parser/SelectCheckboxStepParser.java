package org.mrr.parser;

import java.util.regex.Pattern;

import org.mrr.ActionType;

/**
 * Parser class for the action "Select checkbox".
 */
public class SelectCheckboxStepParser extends AbstractStepParser {
  /**
   * Default constructor.
   * @param testStepDescription String description of the test step.
   * It is expected in this form: "select checkbox checkboxname".
   */
  public SelectCheckboxStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Select checkbox \\w+", "select checkbox");
  }

  @Override
  protected String parseTarget() {
    String[] splitDescription = getTestStepDescription().split(" ");
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
