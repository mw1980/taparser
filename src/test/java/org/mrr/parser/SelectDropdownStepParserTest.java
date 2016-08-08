package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.AutomationStep;

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
  public void whenParsingCorrectDescription_shouldReturnExpectedAutomationBean() {
    final AutomationStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"ui option\"");
    assertThat(parseResult).isEqualTo(new AutomationStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option"));
  }

  @Test
  public void whenParsingCorrectDescriptionWithNumericalOptionValue_shouldReturnExpectedAutomationBean() {
    final AutomationStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"3\"");
    assertThat(parseResult).isEqualTo(new AutomationStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "3"));
  }

  @Test
  public void whenParsingDescription_shouldReturnExpectedAutomationBeanWithCapitalLetters() {
    final AutomationStep parseResult = new SelectDropdownStepParserTemplate().parse("Select in dropdown mydropdown value \"Johnie Walker\"");
    assertThat(parseResult).isEqualTo(new AutomationStep(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "Johnie Walker"));
  }
}