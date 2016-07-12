package org.mrr.generator;

import org.mrr.ActionType;
import org.mrr.AutomationStep;

/**
 * Factory class for Code Generators.
 */
public class CodeGeneratorFactory {

  private CodeGeneratorFactory() {
    //the constructor is hidden.
  }

  /**
   * Returns a code generator object for the automation step bean received as parameter.
   * @param automationStep the automation step bean to generate automation code for.
   * @return code generator object for the automation step bean.
   */
  public static AbstractCodeGenerator newInstance(AutomationStep automationStep) {
    if (ActionType.LOAD_PAGE.equals(automationStep.actionType())) {
      return new LoadPageCodeGenerator(automationStep);
    } else if (ActionType.EDIT_TEXT.equals(automationStep.actionType())) {
      return new EditTextfieldCodeGenerator(automationStep);
    } else if (ActionType.CLICK_BUTTON.equals(automationStep.actionType())) {
      return new ClickButtonCodeGenerator(automationStep);
    } else if (ActionType.SELECT_IN_DROPDOWN.equals(automationStep.actionType())) {
      return new SelectInDropdownCodeGenerator(automationStep);
    } else if (ActionType.SELECT_CHECKBOX.equals(automationStep.actionType())) {
      return new SelectCheckboxCodeGenerator(automationStep);
    } else if (ActionType.DESELECT_CHECKBOX.equals(automationStep.actionType())) {
      return new DeselectCheckboxCodeGenerator(automationStep);
    }
    throw new CodeGeneratorNotIdentifiedException("The code generator for the action identificationType: \""
      + automationStep.actionType().getText() + "\" is not found.");
  }
}
