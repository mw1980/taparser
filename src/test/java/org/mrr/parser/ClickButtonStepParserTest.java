package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonStepParserTest {

  @Test(expected = UnparsableDescription.class)
  public void whenParsingMalformedButtonStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click button firstbutton secondbutton").validate();
  }

  @Test
  public void whenParsingWellFormedButtonStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser("Click button singlebutton").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenParsingUppercaseButtonDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click Button firstButton").validate();
  }

  @Test
  public void whenParsingCorrectButtonDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStep calculated = new ClickButtonStepParser("Click button submitform").parse();
    final AutomationStep expected = new AutomationStep(ActionType.CLICK_BUTTON, "submitform", "");
    assertThat(calculated).isEqualTo(expected);
  }

  @Test(expected = UnparsableDescription.class)
  public void whenParsingMalformedLinkStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click link firstbutton secondbutton").validate();
  }

  @Test
  public void whenParsingWellFormedLinkStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser("Click link singlebutton").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenParsingUppercaseLinkDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click Link firstButton").validate();
  }

  @Test
  public void whenParsingCorrectLinkDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStep calculated = new ClickButtonStepParser("Click link submitform").parse();
    assertThat(calculated).isEqualTo(new AutomationStep(ActionType.CLICK_BUTTON, "submitform", ""));
  }
}