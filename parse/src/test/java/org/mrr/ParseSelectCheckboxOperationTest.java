package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

public class ParseSelectCheckboxOperationTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingWrongCheckboxNameText_shouldThrowDescriptionNotParsableException() {
    new ParseSelectCheckboxOperation().validate("Select checkbox my first checkbox");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithMissingCheckboxText_shouldThrowDescriptionNotParsableException() {
    new ParseSelectCheckboxOperation().validate("Select myCheckbox");
  }

  @Test
  public void whenParsingCorrectDescription_shouldParseAsExpected() {
    final Action parsed = new ParseSelectCheckboxOperation().actionFrom("Select checkbox a");
    final Action expected = new Action(SELECT_CHECKBOX, "a", "");
    assertThat(parsed).isEqualTo(expected);
  }
}
