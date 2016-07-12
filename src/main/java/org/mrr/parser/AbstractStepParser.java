package org.mrr.parser;

import org.mrr.ActionType;
import org.mrr.AutomationStep;

import java.util.regex.Pattern;

/**
 * Abstract class, contains the methods to parse test case description and create
 * ActionSteps objects from free text test case description.
 */
public abstract class AbstractStepParser {
  private final String stepDescription;

  AbstractStepParser(final String stepDescription) {
    this.stepDescription = stepDescription;
  }

  /**
   * The action method of the step parser.
   * Parses the action identificationType, the action target and action values from test case description
   * and returns an automationStepBean object.
   * @return Automation Step Bean object parsed from the test case description.
   */
  public AutomationStep parse() {
    validate();
    return new AutomationStep(
      parseActionType(),
      parseTarget(),
      parseValue());
  }

  /**
   * Validation Method. Checks if the step description can be parsed to an AutomationStepObject.
   */
  abstract void validate();

  /**
   * The method identifies the target of test step action from the current test case description.
   * @return the test case action target as string.
   */
  protected abstract String parseTarget();

  /**
   * The method identifies the action identificationType of the test step action from the test case description.
   * @return the test case action identificationType.
   */
  protected abstract ActionType parseActionType();

  /**
   * The method returns the value that the test step action should set.
   * E.g. the value to be set in a text field.
   * @return the value of the action
   */
  protected abstract String parseValue();

  void performBasicValidation(final String regex, final String stepType) {
    if (!Pattern.matches(regex, getStepDescription())) {
      throw new UnparsableDescription("The description: \"" + getStepDescription()
        + "\" is not a valid " + stepType + " step description.");
    }
  }

  String getStepDescription() {
    return stepDescription;
  }
}
