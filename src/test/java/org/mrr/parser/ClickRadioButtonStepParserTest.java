package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickRadioButtonStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongRadioButtonText_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser().validate("Select radiobutton value");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongOptionText_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser().validate("Select radio button per post");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingTargetDescription_shouldThrowDescriptionNotParsableException() {
    new ClickRadioButtonStepParser().validate("Select radio button");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnBeanWithExpectedActionType() {
    final TestStep automationBean = new ClickRadioButtonStepParser().parse("Select radio button 1");
    assertThat(automationBean).isEqualTo(new TestStep(ActionType.CLICK_BUTTON, "1", ""));
  }
}