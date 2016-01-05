package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectDropdownStepParserTest {

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingEmptyDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParser("").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingMalformedDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParser("Select dropdown mydropdown value \"5\"").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingMissingValueInDescription_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParser("Select in dropdown mydropdown \"ui label\"").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowDescriptionNotParsableException() {
    new SelectDropdownStepParser("Select in dropdown mydropdown value ui option").validate();
  }

  @Test
  public void whenParsingCorrectDescription_shouldReturnExpectedAutomationBean() {
    final AutomationStepBean parseResult = new SelectDropdownStepParser("Select in dropdown mydropdown value \"ui option\"").parse();
    assertThat(parseResult).isEqualTo(new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option"));
  }

  @Test
  public void whenParsingCorrectDescriptionWithNumericalOptionValue_shouldReturnExpectedAutomationBean() {
    final AutomationStepBean parseResult = new SelectDropdownStepParser("Select in dropdown mydropdown value \"3\"").parse();
    assertThat(parseResult).isEqualTo(new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "3"));
  }

  @Test
  public void whenParsingDescription_shouldReturnExpectedAutomationBeanWithCapitalLetters() {
    final AutomationStepBean parseResult = new SelectDropdownStepParser("Select in dropdown mydropdown value \"Johnie Walker\"").parse();
    assertThat(parseResult).isEqualTo(new AutomationStepBean(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "Johnie Walker"));
  }
}