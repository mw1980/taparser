package org.mrr.generator;

import org.junit.Test;
import org.mrr.ActionType;
import org.mrr.AutomationStepBean;

import static org.junit.Assert.*;

public class LoadPageCodeGeneratorTest {

  @Test
  public void testGenerateCode() throws Exception {
    final LoadPageCodeGenerator loadPageCodeGenerator = new LoadPageCodeGenerator(newSampleAutomationBean());
    assertEquals("driver.get(\"www.google.com\");", loadPageCodeGenerator.generateCode());
  }

  private AutomationStepBean newSampleAutomationBean() {
    return new AutomationStepBean(ActionType.LOAD_PAGE, "", "www.google.com");
  }
}