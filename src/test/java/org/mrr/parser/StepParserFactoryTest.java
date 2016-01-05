package org.mrr.parser;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StepParserFactoryTest {

  @Test
  public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
    final AbstractStepParser stepParserCommand = StepParserFactory.newInstance("Load page www.myurl.com");
    assertTrue(stepParserCommand instanceof LoadPageStepParser);
  }

  @Test
  public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
    final AbstractStepParser stepParserCommand = StepParserFactory.newInstance("Set in textfield myfield value 20");
    assertTrue(stepParserCommand instanceof EditTextfieldStepParser);
  }

  @Test
  public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
    final AbstractStepParser clickButtonCommand = StepParserFactory.newInstance("Click button submit");
    assertTrue(clickButtonCommand instanceof ClickButtonStepParser);
  }

  @Test
  public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
    final AbstractStepParser stepParser = StepParserFactory.newInstance("Select in dropdown clients value \"johnie walker\"");
    assertTrue(stepParser instanceof SelectDropdownStepParser);
  }

  @Test
  public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
    final AbstractStepParser stepParser = StepParserFactory.newInstance("Select checkbox iAgree");
    assertTrue(stepParser instanceof SelectCheckboxStepParser);
  }

  @Test
  public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
    final AbstractStepParser stepParser = StepParserFactory.newInstance("Deselect checkbox iAgree");
    assertTrue(stepParser instanceof DeselectCheckboxStepParser);
  }

  @Test
  public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
    final AbstractStepParser stepParser = StepParserFactory.newInstance("Select radio button perEmail");
    assertTrue(stepParser instanceof ClickRadioButtonStepParser);
  }
}