package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.domain.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

public class SelectCheckboxStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongCheckboxNameText_shouldThrowDescriptionNotParsableException() {
    new SelectCheckboxStepParser().validate("Select checkbox my first checkbox");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithMissingCheckboxText_shouldThrowDescriptionNotParsableException() {
    new SelectCheckboxStepParser().validate("Select myCheckbox");
  }

  @Test
  public void whenParsingCorrectDescription_shouldParseAsExpected() {
    final AutomationStep expected = new AutomationStep(SELECT_CHECKBOX, "a", "");
    final AutomationStep calculated = new SelectCheckboxStepParser().parse("Select checkbox a");
    assertThat(calculated).isEqualTo(expected);
  }
}
