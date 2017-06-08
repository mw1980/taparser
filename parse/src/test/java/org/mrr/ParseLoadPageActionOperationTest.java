package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the class LoadPageActionOperationParse.
 */
public class ParseLoadPageActionOperationTest {
  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingUrlDescription_shouldThrowDescriptionNotParsableException() {
    new ParseLoadPageActionOperation().validate("Load page");
  }

  @Test(expected = DescriptionNotParsableException.class)
  public void whenValidatingMissingPageDescription_shouldThrowDescriptionNotParsableException() {
    new ParseLoadPageActionOperation().validate("Load http://www.google.com");
  }

  @Test
  public void whenParsingLoadAction_shouldReturnLoadActionTypeValueAndNoActionTarget() {
    final Action parsed = new ParseLoadPageActionOperation().actionFrom("Load page http://www.google.de");
    final Action expected = new Action(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertThat(parsed).isEqualTo(expected);
  }

}
