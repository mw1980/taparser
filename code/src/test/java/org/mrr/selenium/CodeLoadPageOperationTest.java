package org.mrr.selenium;

import org.junit.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CodeLoadPageOperationTest {

    @Test
    public void testGenerateCode() throws Exception {
        final CodeLoadPageOperation underTest = new CodeLoadPageOperation();
        assertThat(
                underTest.codeFor(new Action(ActionType.LOAD_PAGE, "", "www.google.com")),
                equalTo("driver.get(\"www.google.com\");"));
    }
}