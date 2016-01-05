package org.mrr.parser;

import org.mrr.ActionType;

import java.util.regex.Pattern;

/**
 * Parses class for the step: "click button buttonname".
 */
public class ClickButtonStepParser extends AbstractStepParser {

  /**
   * Default constructor.
   * @param testStepDescription step description, in this form "click button buttonName".
   */
  public ClickButtonStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    if (isNoClickDescription("button") && (isNoClickDescription("link"))) {
      throw new UnparsableDescription("The test step description '" + getStepDescription()
        + "' cannot be parsed to a click button step.");
    }
  }

  private boolean isNoClickDescription(String elementType) {
    return !Pattern.matches("Click " + elementType + " [a-z]+", getStepDescription());
  }

  @Override
  protected String parseTarget() {
    final String[] descriptionWords = getStepDescription().split(" ");
    /*
     * position 0: click
     * position 1: button
     * position 2: buttonName
     */
    return descriptionWords[2];
  }

  @Override
  protected ActionType parseActionType() {
    return ActionType.CLICK_BUTTON;
  }

  @Override
  protected String parseValue() {
    return "";
  }
}
