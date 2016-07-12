package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Step parser for the actions of identificationType select value in Dropdown.
 */
public class SelectDropdownStepParser extends AbstractStepParser {
  /**
   * Default Constructor.
   * @param stepDescription in this form "select in dropdown dropdownName value \"Surname Name\""
   */
  public SelectDropdownStepParser(final String stepDescription) {
    super(stepDescription);
  }

  @Override
  void validate() {
    final String regex = "Select in dropdown\\s\\w+\\svalue\\s\"[a-zA-Z0-9 ]+\"";
    super.performBasicValidation(regex, "select in dropdown");
  }

  @Override
  protected String parseTarget() {
    String[] split = getStepDescription().replaceAll("Select in dropdown ", "").split("value");
    return split[0].trim();
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.SELECT_IN_DROPDOWN;
  }

  @Override
  protected String parseValue() {
    final String[] split = getStepDescription().split("\"");
    return split[1];
  }
}
