package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStep;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for the class LoadPageStepParser.
 */
public class LoadPageStepParserTest {
  @Test(expected = UnparsableDescription.class)
  public void whenValidatingMissingUrlDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageStepParser("Load page").validate();
  }

  @Test(expected = UnparsableDescription.class)
  public void whenValidatingMissingPageDescription_shouldThrowDescriptionNotParsableException() {
    new LoadPageStepParser("Load http://www.google.com").validate();
  }

  @Test
  public void whenParsingLoadAction_shouldReturnLoadActionTypeValueAndNoActionTarget() {
    final AutomationStep automationStep = new LoadPageStepParser("Load page http://www.google.de").parse();
    final AutomationStep expected = new AutomationStep(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertEquals(expected, automationStep);
  }

}
