package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.ActionType;
import org.mrr.core.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

public class DeselectCheckboxStepParserTest {

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithWrongCheckboxName_shouldThrowDescriptionNotParsableException(){
    new DeselectCheckboxStepParser().validate("Deselect checkbox my first checkbox");
  }

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithMissingCheckbox_shouldThrowDescriptionNotParsableException(){
    new DeselectCheckboxStepParser().validate("Deselect agreeWithCookies");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedBean(){
    final AutomationStep parsedBean = new DeselectCheckboxStepParser().parse("Deselect checkbox agreecookies");
    assertThat(parsedBean).isEqualTo(new AutomationStep(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
  }
}