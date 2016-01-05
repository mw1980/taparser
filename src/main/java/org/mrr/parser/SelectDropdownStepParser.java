package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Step parser for the actions of type select value in Dropdown.
 */
public class SelectDropdownStepParser extends AbstractStepParser {
  /**
   * Default Constructor.
   * @param testStepDescription free text description of the test step.
   * The description is expected in this form: "select in dropdown dropdownName value \"Surname Name\""
   */
  public SelectDropdownStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Select in dropdown\\s\\w+\\svalue\\s\"[a-zA-Z0-9 ]+\"", "select in dropdown");
  }

  @Override
  protected String parseTarget() {
    String[] splitString = getTestStepDescription().replaceAll("Select in dropdown ", "").split("value");
    return splitString[0].trim();
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.SELECT_IN_DROPDOWN;
  }

  @Override
  protected String parseValue() {
    final String[] split = getTestStepDescription().split("\"");
    return split[1];
  }
}
