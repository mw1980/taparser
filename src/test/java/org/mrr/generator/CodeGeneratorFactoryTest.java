package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.junit.Assert.assertTrue;

public class CodeGeneratorFactoryTest {

  @Test
  public void whenCreatingInstanceForLoadPageAutomationBean_shouldReturnLoadPageCodeGenerator() {
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.LOAD_PAGE, "", ""));
    assertTrue(codeGenerator instanceof LoadPageCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForEditTextAutomationBean_shouldReturnEditTextCodeGenerator() {
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.EDIT_TEXT, "", ""));
    assertTrue(codeGenerator instanceof EditTextfieldCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForClickButtonBean_shouldReturnClickButtonCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.CLICK_BUTTON, "", ""));
    assertTrue(codeGenerator instanceof ClickButtonCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForSelectInDropdownAutomationBean_shouldReturnSelectInDropdownGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.SELECT_IN_DROPDOWN, "", ""));
    assertTrue(codeGenerator instanceof SelectInDropdownCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForSelectCheckboxAutomationBean_shouldReturnSelectCheckboxCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.SELECT_CHECKBOX, "", null));
    assertTrue(codeGenerator instanceof SelectCheckboxCodeGenerator);
  }

  @Test
  public void whenCreatingInstanceForDeselectCheckboxAutomationBean_shouldReturnDeselectCheckboxCodeGenerator(){
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(new TestStep(ActionType.DESELECT_CHECKBOX, "", null));
    assertTrue(codeGenerator instanceof DeselectCheckboxCodeGenerator);
  }
}
