package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.ActionType;
import org.mrr.core.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedButtonStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser().validate("Click button firstbutton secondbutton");
  }

  @Test
  public void whenParsingWellFormedButtonStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser().validate("Click button singlebutton");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseButtonDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser().validate("Click Button firstButton");
  }

  @Test
  public void whenParsingCorrectButtonDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStep calculated = new ClickButtonStepParser().parse("Click button submitform");
    final AutomationStep expected = new AutomationStep(ActionType.CLICK_BUTTON, "submitform", "");
    assertThat(calculated).isEqualTo(expected);
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedLinkStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser().validate("Click link firstbutton secondbutton");
  }

  @Test
  public void whenParsingWellFormedLinkStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser().validate("Click link singlebutton");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseLinkDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser().validate("Click Link firstButton");
  }

  @Test
  public void whenParsingCorrectLinkDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStep calculated = new ClickButtonStepParser().parse("Click link submitform");
    assertThat(calculated).isEqualTo(new AutomationStep(ActionType.CLICK_BUTTON, "submitform", ""));
  }
}