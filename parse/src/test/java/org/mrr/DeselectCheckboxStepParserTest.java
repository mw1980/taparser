package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

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
    final TestStep parsedBean = new DeselectCheckboxStepParser().parse("Deselect checkbox agreecookies");
    assertThat(parsedBean).isEqualTo(new TestStep(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
  }
}