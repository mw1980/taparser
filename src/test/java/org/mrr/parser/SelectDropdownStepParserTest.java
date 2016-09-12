package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectDropdownStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingEmptyDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParserTemplate().validate("");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMalformedDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParserTemplate().validate("Select dropdown mydropdown value \"5\"");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingValueInDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParserTemplate().validate("Select in dropdown mydropdown \"ui label\"");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParserTemplate().validate("Select in dropdown mydropdown value ui option");
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedTestStep() {
    final TestStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"ui option\"");
    assertThat(parseResult).isEqualTo(new TestStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option"));
  }

  @Test
  public void whenParsingCorrectDescriptionWithNumericalOptionValue_shouldReturnExpectedTestStep() {
    final TestStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"3\"");
    assertThat(parseResult).isEqualTo(new TestStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "3"));
  }

  @Test
  public void whenParsingDescription_shouldReturnExpectedTestStepWithCapitalLetters() {
    final TestStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"Johnie Walker\"");
    assertThat(parseResult).isEqualTo(new TestStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "Johnie Walker"));
  }
}