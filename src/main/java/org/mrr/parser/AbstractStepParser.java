package org.mrr.parser;

import java.util.regex.Pattern;

import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

/**
 * Abstract class, contains the methods to parse test case description and create
 * ActionSteps objects from free text test case description.
 */
public abstract class AbstractStepParser {
  private final String testStepDescription;

  AbstractStepParser(final String testStepDescription) {
    this.testStepDescription = testStepDescription;
  }

  /**
   * The action method of the step parser.
   * Parses the action type, the action target and action values from test case description
   * and returns an automationStepBean object.
   * @return Automation Step Bean object parsed from the test case description.
   */
  public AutomationStepBean parse() {
    validate();
    return new AutomationStepBean(
      parseActionType(),
      parseTarget(),
      parseValue());
  }

  /**
   * Validation Method. Checks if the step description text ha the right form to be parsed to an AutomationStepObject.
   */
  abstract void validate();

  /**
   * The method identifies the target of the test step action from the current test case description.
   * @return the test case action target as string.
   */
  protected abstract String parseTarget();

  /**
   * The method identifies the action type of the test step action from the current test case description.
   * @return the test case action type.
   */
  protected abstract ActionType parseActionType();

  /**
   * The method returns the value that the test step action should set.
   * E.g. the value to be set in a text field.
   * @return the value of the action
   */
  protected abstract String parseValue();

  void performBasicValidation(final String regex, final String stepType){
    if (!Pattern.matches(regex, getTestStepDescription())) {
      throw new DescriptionNotParsableException("The description: \"" + getTestStepDescription() + "\" is not a valid " + stepType + " step description.");
    }
  }

  String getTestStepDescription() {
    return testStepDescription;
  }
}
