package org.mrr.parser;

import org.mrr.ActionType;

/**
 * The class contains methods to generate edit text field automation bean object from plain text description.
 */
public class EditTextfieldStepParser extends AbstractStepParser {

  /**
   * Default Constructor.
   * @param testCaseDescription free text description for the edit text field step.
   * The description is expected in this form: set in textfield myTextfield value "word1 word2 ... wordn"
   */
  public EditTextfieldStepParser(final String testCaseDescription) {
    super(testCaseDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Set in textfield\\s\\w+\\svalue\\s\"[a-zA-Z0-9_ ]+\"", "edit text field");
  }

  @Override
  protected String parseTarget() {
    final String[] testCaseWords = getTestStepDescription().split(" ");
    return testCaseWords[3];
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.EDIT_TEXT;
  }

  @Override
  protected String parseValue() {
    String[] actionTokens = getTestStepDescription().split("value ");
    return actionTokens[1].replace("\"", "");
  }
}
