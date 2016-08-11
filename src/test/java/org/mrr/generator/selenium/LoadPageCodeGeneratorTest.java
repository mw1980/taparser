package org.mrr.generator.selenium;

import org.junit.Test;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LoadPageCodeGeneratorTest {

    @Test
    public void testGenerateCode() throws Exception {
        final LoadPageCodeGenerator loadPageCodeGenerator = new LoadPageCodeGenerator();
        final TestStep testStep = new TestStep(ActionType.LOAD_PAGE, "", "www.google.com");
        assertThat(loadPageCodeGenerator.generateCode(testStep), equalTo("driver.get(\"www.google.com\");"));
    }
}