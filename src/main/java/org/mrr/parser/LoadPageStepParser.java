package org.mrr.parser;

import org.mrr.ActionType;

/**
 * The class contains methods to generate automation steps from plain text.
 */
public class LoadPageStepParser extends AbstractStepParser {
  /**
   * Default constructor.
   * @param testCaseDescription test case description, expected in this form: load page url
   */
  public LoadPageStepParser(final String testCaseDescription) {
    super(testCaseDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Load page\\s\\S+", "load page");
  }

  @Override
  protected String parseTarget() {
    return "";
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.LOAD_PAGE;
  }

  @Override
  protected String parseValue() {
    //Expected:
    // - on position 0 the action text: ""
    // - on position 1 the action target: "http://www.myWebPage.com"
    String[] actionTokens = getTestStepDescription().split(ActionType.LOAD_PAGE.getText() + " ");
    return actionTokens[1];
  }
}
