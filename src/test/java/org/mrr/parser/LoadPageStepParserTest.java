package org.mrr.parser;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

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
    final AutomationStepBean automationStepBean = new LoadPageStepParser("Load page http://www.google.de").parse();
    final AutomationStepBean expected = new AutomationStepBean(ActionType.LOAD_PAGE, "", "http://www.google.de");
    assertEquals(expected, automationStepBean);
  }

}
