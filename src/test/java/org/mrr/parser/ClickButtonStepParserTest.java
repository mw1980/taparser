package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedButtonStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click button firstbutton secondbutton").validate();
  }

  @Test
  public void whenParsingWellFormedButtonStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser("Click button singlebutton").validate();
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseButtonDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click Button firstButton").validate();
  }

  @Test
  public void whenParsingCorrectButtonDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStepBean calculated = new ClickButtonStepParser("Click button submitform").parse();
    final AutomationStepBean expected = new AutomationStepBean(ActionType.CLICK_BUTTON, "submitform", "");
    assertThat(calculated).isEqualTo(expected);
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedLinkStepDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click link firstbutton secondbutton").validate();
  }

  @Test
  public void whenParsingWellFormedLinkStepDescription_shouldValidateWithoutException() {
    new ClickButtonStepParser("Click link singlebutton").validate();
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseLinkDescription_shouldThrowDescriptionNotParsableException() {
    new ClickButtonStepParser("Click Link firstButton").validate();
  }

  @Test
  public void whenParsingCorrectLinkDescription_shouldIdentifyTheTargetCorrect() {
    final AutomationStepBean calculated = new ClickButtonStepParser("Click link submitform").parse();
    assertThat(calculated).isEqualTo(new AutomationStepBean(ActionType.CLICK_BUTTON, "submitform", ""));
  }
}