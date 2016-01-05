package org.mrr.parser;

import java.util.regex.Pattern;

import org.mrr.ActionType;

/**
 * Parses class for the step: "click button buttonname"
 */
public class ClickButtonStepParser extends AbstractStepParser {

  /**
   * Default constructor.
   * @param testStepDescription the description of the step to be parsed.
   * The step description is expected in this form: "click button buttonName".
   */
  public ClickButtonStepParser(final String testStepDescription) {
    super(testStepDescription);
  }

  @Override
  void validate() {
    if (isNoClickDescription("button") && (isNoClickDescription("link"))) {
      throw new DescriptionNotParsableException("The test step description '" + getTestStepDescription() + "' cannot be parsed to a click button step.");
    }
  }

  private boolean isNoClickDescription(String elementType) {
    return !Pattern.matches("Click " + elementType + " [a-z]+", getTestStepDescription());
  }

  @Override
  protected String parseTarget() {
    final String[] descriptionWords = getTestStepDescription().split(" ");
    /**
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
