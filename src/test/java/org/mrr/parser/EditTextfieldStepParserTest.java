package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class EditTextfieldStepParser.
 */
public class EditTextfieldStepParserTest {
  @Test(expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithoutValue_shouldThrowDescriptionNotParsableException(){
    new EditTextfieldStepParser("Set in textfield login \"user name\"").validate();
  }

  @Test (expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParableException(){
    new EditTextfieldStepParser("Set in textfied login value user").validate();
  }

  @Test
  public void shouldParseBasicStepDescriptionTextAsExpected(){
    AutomationStep calculated = new EditTextfieldStepParser("Set in textfield login value \"my user name\"").parse();
    assertThat(calculated).isEqualTo(new AutomationStep(ActionType.EDIT_TEXT, "login", "my user name"));
  }
}