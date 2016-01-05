package org.mrr.generator;

import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

/**
 * Factory class for Code Generators.
 */
public class CodeGeneratorFactory {

  private CodeGeneratorFactory() {
    //the constructor is hidden.
  }

  /**
   * Returns a code generator object for the automation step bean received as parameter.
   * @param automationStepBean the automation step bean to generate automation code for.
   * @return code generator object for the automation step bean.
   */
  public static AbstractCodeGenerator newInstance(AutomationStepBean automationStepBean) {
    if (ActionType.LOAD_PAGE.equals(automationStepBean.getActionType())) {
      return new LoadPageCodeGenerator(automationStepBean);
    } else if (ActionType.EDIT_TEXT.equals(automationStepBean.getActionType())) {
      return new EditTextfieldCodeGenerator(automationStepBean);
    } else if (ActionType.CLICK_BUTTON.equals(automationStepBean.getActionType())) {
      return new ClickButtonCodeGenerator(automationStepBean);
    } else if (ActionType.SELECT_IN_DROPDOWN.equals(automationStepBean.getActionType())) {
      return new SelectInDropdownCodeGenerator(automationStepBean);
    } else if (ActionType.SELECT_CHECKBOX.equals(automationStepBean.getActionType())) {
      return new SelectCheckboxCodeGenerator(automationStepBean);
    } else if (ActionType.DESELECT_CHECKBOX.equals(automationStepBean.getActionType())) {
      return new DeselectCheckboxCodeGenerator(automationStepBean);
    }
    throw new CodeGeneratorNotIdentifiedException("The code generator for the action type: \""
      + automationStepBean.getActionType().getText() + "\" is not found.");
  }
}
