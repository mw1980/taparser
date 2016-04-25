package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

public class DeselectCheckboxStepParserTest {

  @Test (expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithWrongCheckboxName_shouldThrowDescriptionNotParsableException(){
    new DeselectCheckboxStepParser("Deselect checkbox my first checkbox").validate();
  }

  @Test (expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithMissingCheckbox_shouldThrowDescriptionNotParsableException(){
    new DeselectCheckboxStepParser("Deselect agreeWithCookies").validate();
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedBean(){
    final AutomationStep parsedBean = new DeselectCheckboxStepParser("Deselect checkbox agreecookies").parse();
    assertThat(parsedBean).isEqualTo(new AutomationStep(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
  }
}