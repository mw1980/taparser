package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickRadioButtonStepParserTest {

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingWrongRadioButtonText_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser("Select radiobutton value").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingWrongOptionText_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser("Select radio button per post").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingMissingTargetDescription_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser("Select radio button").validate();
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnBeanWithExpectedActionType() {
    final AutomationStepBean automationBean = new ClickRadioButtonStepParser("Select radio button 1").parse();
    assertThat(automationBean).isEqualTo(new AutomationStepBean(ActionType.CLICK_BUTTON, "1", ""));
  }
}