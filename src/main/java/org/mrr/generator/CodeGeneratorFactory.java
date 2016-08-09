package org.mrr.generator;

import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

/**
 * Factory class for Code Generators.
 */
public class CodeGeneratorFactory {

  private CodeGeneratorFactory() {
    //the constructor is hidden.
  }

  /**
   * Returns a code generator object for the automation step bean received as parameter.
   * @param testStep the automation step bean to generate automation code for.
   * @return code generator object for the automation step bean.
   */
  public static AbstractCodeGenerator newInstance(TestStep testStep) {
    if (ActionType.LOAD_PAGE.equals(testStep.actionType())) {
      return new LoadPageCodeGenerator(testStep);
    } else if (ActionType.EDIT_TEXT.equals(testStep.actionType())) {
      return new EditTextfieldCodeGenerator(testStep);
    } else if (ActionType.CLICK_BUTTON.equals(testStep.actionType())) {
      return new ClickButtonCodeGenerator(testStep);
    } else if (ActionType.SELECT_IN_DROPDOWN.equals(testStep.actionType())) {
      return new SelectInDropdownCodeGenerator(testStep);
    } else if (ActionType.SELECT_CHECKBOX.equals(testStep.actionType())) {
      return new SelectCheckboxCodeGenerator(testStep);
    } else if (ActionType.DESELECT_CHECKBOX.equals(testStep.actionType())) {
      return new DeselectCheckboxCodeGenerator(testStep);
    }
    throw new CodeGeneratorNotIdentifiedException("The code generator for the action type: \""
            + testStep.actionType().text() + "\" is not found.");
  }
}
