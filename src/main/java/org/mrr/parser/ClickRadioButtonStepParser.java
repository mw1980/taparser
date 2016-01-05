package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Parser class for the action steps in form: "select radio button radioButtonOption".
 */
public class ClickRadioButtonStepParser extends AbstractStepParser {
  public ClickRadioButtonStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    super.performBasicValidation("Select radio button\\s\\w+", "click radio button");
  }

  @Override
  protected String parseTarget() {
    String[] splitDescription = getTestStepDescription().split(" ");
    return splitDescription[3];
  }

  @Override
  protected ActionType parseActionType() {
    //From selenium point of view, the selection of a radio button is a radio button click.
    return ActionType.CLICK_BUTTON;
  }

  @Override
  protected String parseValue() {
    return "";
  }
}
