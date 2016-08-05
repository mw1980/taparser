package org.mrr.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mrr.core.ActionType;
import org.mrr.core.AutomationStep;
import org.mrr.CodeGeneratorBaseTest;

public class LoadPageCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void testGenerateCode() throws Exception {
    final LoadPageCodeGenerator loadPageCodeGenerator = new LoadPageCodeGenerator(newSampleAutomationBean());
    assertEquals("driver.get(\"www.google.com\");", loadPageCodeGenerator.generateCode());
  }

  private AutomationStep newSampleAutomationBean() {
    return new AutomationStep(ActionType.LOAD_PAGE, "", "www.google.com");
  }
}