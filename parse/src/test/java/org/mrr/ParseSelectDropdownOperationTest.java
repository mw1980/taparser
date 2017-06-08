package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseSelectDropdownOperationTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingEmptyDescription_shouldThrowDescriptionNotParsableException() {
    new ParseSelectDropdownOperation().validate("");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMalformedDescription_shouldThrowDescriptionNotParsableException() {
    new ParseSelectDropdownOperation().validate("Select dropdown mydropdown value \"5\"");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingValueInDescription_shouldThrowDescriptionNotParsableException() {
    new ParseSelectDropdownOperation().validate("Select in dropdown mydropdown \"ui label\"");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParsableException() {
    new ParseSelectDropdownOperation().validate("Select in dropdown mydropdown value ui option");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedTestStep() {
    final Action parsed = new ParseSelectDropdownOperation().actionFrom("Select in dropdown mydropdown value \"ui option\"");
    assertThat(parsed).isEqualTo(new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option"));
  }

  @Test
  public void whenParsingCorrectDescriptionWithNumericalOptionValue_shouldReturnExpectedTestStep() {
    final Action parsed = new ParseSelectDropdownOperation().actionFrom("Select in dropdown mydropdown value \"3\"");
    assertThat(parsed).isEqualTo(new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "3"));
  }

  @Test
  public void whenParsingDescription_shouldReturnExpectedTestStepWithCapitalLetters() {
    final Action parsed = new ParseSelectDropdownOperation().actionFrom("Select in dropdown mydropdown value \"Johnie Walker\"");
    assertThat(parsed).isEqualTo(new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "Johnie Walker"));
  }
}