package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

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
    final TestStep testStep = new LoadPageStepParser().parse("Load page http://www.google.de");
    final TestStep expected = new TestStep(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertThat(testStep).isEqualTo(expected);
  }

}
