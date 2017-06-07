package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class LoadPageActionOperationParse.
 */
public class LoadPageStepParserTest {
  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingUrlDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageActionOperationParse().validate("Load page");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingPageDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageActionOperationParse().validate("Load http://www.google.com");
  }

  @Test
  public void whenParsingLoadAction_shouldReturnLoadActionTypeValueAndNoActionTarget() {
    final Action action = new LoadPageActionOperationParse().actionFrom("Load page http://www.google.de");
    final Action expected = new Action(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertThat(action).isEqualTo(expected);
  }

}
