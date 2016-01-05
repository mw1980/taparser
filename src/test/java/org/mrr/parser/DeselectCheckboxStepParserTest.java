package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

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
    final AutomationStepBean parsedBean = new DeselectCheckboxStepParser("Deselect checkbox agreecookies").parse();
    assertThat(parsedBean).isEqualTo(new AutomationStepBean(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
  }
}