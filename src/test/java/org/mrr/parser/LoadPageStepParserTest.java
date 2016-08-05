package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.ActionType;
import org.mrr.core.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class LoadPageStepParser.
 */
public class LoadPageStepParserTest {
  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingUrlDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageStepParser().validate("Load page");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingPageDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageStepParser().validate("Load http://www.google.com");
  }

  @Test
  public void whenParsingLoadAction_shouldReturnLoadActionTypeValueAndNoActionTarget() {
    final AutomationStep automationStep = new LoadPageStepParser().parse("Load page http://www.google.de");
    final AutomationStep expected = new AutomationStep(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertThat(automationStep).isEqualTo(expected);
  }

}
