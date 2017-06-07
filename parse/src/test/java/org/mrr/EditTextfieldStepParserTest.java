package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class EditTextfieldActionOperationTemplateParse.
 */
public class EditTextfieldStepParserTest {
  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutValue_shouldThrowDescriptionNotParsableException(){
    new ParseEditTextfieldOperation().validate("Set in textfield login \"user name\"");
  }

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParableException(){
    new ParseEditTextfieldOperation().validate("Set in textfied login value user");
  }

  @Test
  public void shouldParseBasicStepDescriptionTextAsExpected(){
    Action calculated = new ParseEditTextfieldOperation().actionFrom("Set in textfield login value \"my user name\"");
    assertThat(calculated).isEqualTo(new Action(ActionType.EDIT_TEXT, "login", "my user name"));
  }
}