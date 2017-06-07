package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonStepParserTest {

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedButtonStepDescription_shouldThrowDescriptionNotParsableException() {
    new ParseClickButtonOperation().validate("Click button firstbutton secondbutton");
  }

  @Test
  public void whenParsingWellFormedButtonStepDescription_shouldValidateWithoutException() {
    new ParseClickButtonOperation().validate("Click button singlebutton");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseButtonDescription_shouldThrowDescriptionNotParsableException() {
    new ParseClickButtonOperation().validate("Click Button firstButton");
  }

  @Test
  public void whenParsingCorrectButtonDescription_shouldIdentifyTheTargetCorrect() {
    final Action calculated = new ParseClickButtonOperation().actionFrom("Click button submitform");
    final Action expected = new Action(ActionType.CLICK_BUTTON, "submitform", "");
    assertThat(calculated).isEqualTo(expected);
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingMalformedLinkStepDescription_shouldThrowDescriptionNotParsableException() {
    new ParseClickButtonOperation().validate("Click link firstbutton secondbutton");
  }

  @Test
  public void whenParsingWellFormedLinkStepDescription_shouldValidateWithoutException() {
    new ParseClickButtonOperation().validate("Click link singlebutton");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenParsingUppercaseLinkDescription_shouldThrowDescriptionNotParsableException() {
    new ParseClickButtonOperation().validate("Click Link firstButton");
  }

  @Test
  public void whenParsingCorrectLinkDescription_shouldIdentifyTheTargetCorrect() {
    final Action calculated = new ParseClickButtonOperation().actionFrom("Click link submitform");
    assertThat(calculated).isEqualTo(new Action(ActionType.CLICK_BUTTON, "submitform", ""));
  }
}