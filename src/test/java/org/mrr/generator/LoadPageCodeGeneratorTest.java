package org.mrr.generator;

import org.junit.Test;
import org.mrr.CodeGeneratorBaseTest;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.junit.Assert.assertEquals;

public class LoadPageCodeGeneratorTest extends CodeGeneratorBaseTest {

  @Test
  public void testGenerateCode() throws Exception {
    final LoadPageCodeGenerator loadPageCodeGenerator = new LoadPageCodeGenerator(newSampleAutomationBean());
    assertEquals("driver.get(\"www.google.com\");", loadPageCodeGenerator.generateCode());
  }

  private TestStep newSampleAutomationBean() {
    return new TestStep(ActionType.LOAD_PAGE, "", "www.google.com");
  }
}