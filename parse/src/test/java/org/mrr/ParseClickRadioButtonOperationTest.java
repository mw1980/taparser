package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseClickRadioButtonOperationTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongRadioButtonText_shouldThrowDescriptionNotParsableException() {
    new ParseClickRadioButtonOperation().validate("Select radiobutton value");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongOptionText_shouldThrowDescriptionNotParsableException() {
    new ParseClickRadioButtonOperation().validate("Select radio button per post");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingTargetDescription_shouldThrowDescriptionNotParsableException() {
    new ParseClickRadioButtonOperation().validate("Select radio button");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnBeanWithExpectedActionType() {
    final Action parsed = new ParseClickRadioButtonOperation().actionFrom("Select radio button 1");
    assertThat(parsed).isEqualTo(new Action(ActionType.CLICK_BUTTON, "1", ""));
  }
}