package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Parser class for the edit text field steps.
 */
public class EditTextfieldStepParser extends AbstractStepParser {

  /**
   * Default Constructor.
   * @param stepDescription in the form: set in textfield myTextfield value "word1 word2 ... wordn"
   */
  public EditTextfieldStepParser(final String stepDescription) {
    super(stepDescription);
  }

  @Override
  void validate() {
    final String regex = "Set in textfield\\s\\w+\\svalue\\s\"[a-zA-Z0-9_ ]+\"";
    super.performBasicValidation(regex, "edit text field");
  }

  @Override
  protected String parseTarget() {
    final String[] testCaseWords = getStepDescription().split(" ");
    return testCaseWords[3];
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.EDIT_TEXT;
  }

  @Override
  protected String parseValue() {
    String[] actionTokens = getStepDescription().split("value ");
    return actionTokens[1].replace("\"", "");
  }
}
