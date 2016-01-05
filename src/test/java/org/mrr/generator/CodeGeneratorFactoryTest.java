package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.junit.Assert.assertTrue;

public class CodeGeneratorFactoryTest {

  @Test
  public void whenCreatingInstanceForLoadPageAutomationBean_shouldReturnLoadPageCodeGenerator() {
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.LOAD_PAGE, "", ""));
    assertTrue(codeGenerator instanceof LoadPageCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForEditTextAutomationBean_shouldReturnEditTextCodeGenerator() {
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.EDIT_TEXT, "", ""));
    assertTrue(codeGenerator instanceof EditTextfieldCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForClickButtonBean_shouldReturnClickButtonCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.CLICK_BUTTON, "", ""));
    assertTrue(codeGenerator instanceof ClickButtonCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForSelectInDropdownAutomationBean_shouldReturnSelectInDropdownGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "", ""));
    assertTrue(codeGenerator instanceof SelectInDropdownCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForSelectCheckboxAutomationBean_shouldReturnSelectCheckboxCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.SELECT_CHECKBOX, "", null));
    assertTrue(codeGenerator instanceof SelectCheckboxCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForDeselectCheckboxAutomationBean_shouldReturnDeselectCheckboxCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "", null));
    assertTrue(codeGenerator instanceof DeselectCheckboxCodeGenerator);
  }
}
