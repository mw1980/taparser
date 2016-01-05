package org.mrr.parser;

import org.mrr.ActionType;

/**
 * Factory for Step Generator objects.
 */
public class StepParserFactory {

  private StepParserFactory() {
    //the class contains only static methods, so the constructor is hidden.
  }

  /**
   * The method delivers the right step parser for the test step description.
   * @param stepDescription free text description of the test step.
   * @return concrete object of type AbstractStepParser.
   */
  public static AbstractStepParser newInstance(final String stepDescription) {
    final String trimmedDescription = stepDescription.trim();
    if (trimmedDescription.startsWith(ActionType.LOAD_PAGE.getText())) {
      return new LoadPageStepParser(trimmedDescription);
    } else if (trimmedDescription.startsWith(ActionType.EDIT_TEXT.getText())) {
      return new EditTextfieldStepParser(trimmedDescription);
    } else if (isClickAction(trimmedDescription)) {
      return new ClickButtonStepParser(trimmedDescription);
    } else if (trimmedDescription.startsWith(ActionType.SELECT_IN_DROPDOWN.getText())) {
      return new SelectDropdownStepParser(trimmedDescription);
    } else if (trimmedDescription.startsWith(ActionType.SELECT_CHECKBOX.getText())) {
      return new SelectCheckboxStepParser(trimmedDescription);
    } else if (trimmedDescription.startsWith(ActionType.DESELECT_CHECKBOX.getText())) {
      return new DeselectCheckboxStepParser(trimmedDescription);
    } else if (trimmedDescription.startsWith(ActionType.SELECT_RADIO_BUTTON.getText())) {
      return new ClickRadioButtonStepParser(trimmedDescription);
    }
    throw new UnparsableDescription("Cannot identify action in '" + stepDescription + "'.");
  }

  private static boolean isClickAction(final String description) {
    return description.startsWith(ActionType.CLICK_BUTTON.getText())
      || description.startsWith(ActionType.CLICK_LINK.getText());
  }
}
