package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

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
    final AutomationStepBean expected = new AutomationStepBean(ActionType.SELECT_CHECKBOX, "a", "");
    final AutomationStepBean calculated = new SelectCheckboxStepParser("Select checkbox a").parse();
    assertThat(calculated).isEqualTo(expected);
  }
}
