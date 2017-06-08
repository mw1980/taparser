package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseDeselectCheckboxOperationTest {

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithWrongCheckboxName_shouldThrowDescriptionNotParsableException(){
    new ParseDeselectCheckboxOperation().validate("Deselect checkbox my first checkbox");
  }

  @Test (expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithMissingCheckbox_shouldThrowDescriptionNotParsableException(){
    new ParseDeselectCheckboxOperation().validate("Deselect agreeWithCookies");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedBean(){
    final Action parsed = new ParseDeselectCheckboxOperation().actionFrom("Deselect checkbox agreecookies");
    assertThat(parsed).isEqualTo(new Action(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
  }
}