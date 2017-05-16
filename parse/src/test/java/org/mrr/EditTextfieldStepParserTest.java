package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class EditTextfieldStepParserTemplate.
 */
public class EditTextfieldStepParserTest {
  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutValue_shouldThrowDescriptionNotParsableException(){
    new EditTextfieldStepParserTemplate().validate("Set in textfield login \"user name\"");
  }

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParableException(){
    new EditTextfieldStepParserTemplate().validate("Set in textfied login value user");
  }

  @Test
  public void shouldParseBasicStepDescriptionTextAsExpected(){
    TestStep calculated = new EditTextfieldStepParserTemplate().parse("Set in textfield login value \"my user name\"");
    assertThat(calculated).isEqualTo(new TestStep(ActionType.EDIT_TEXT, "login", "my user name"));
  }
}