package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectCheckboxStepParserTest {

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingWrongCheckboxNameText_shouldThrowDescriptionNotParsableException() {
    new SelectCheckboxStepParser("Select checkbox my first checkbox").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithMissingCheckboxText_shouldThrowDescriptionNotParsableException() {
    new SelectCheckboxStepParser("Select myCheckbox").validate();
  }

  @Test
  public void whenParsingCorrectDescription_shouldParseAsExpected() {
    final AutomationStep expected = new AutomationStep(ActionType.SELECT_CHECKBOX, "a", "");
    final AutomationStep calculated = new SelectCheckboxStepParser("Select checkbox a").parse();
    assertThat(calculated).isEqualTo(expected);
  }
}
