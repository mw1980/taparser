package org.mrr.parser;

import org.junit.Test;
import org.mrr.core.domain.TestStep;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mrr.core.domain.ActionType.UNKNOWN;


public class AbstractTestStepParserTemplateTest {
    @Test
    public void nullObjectShouldParseDescriptionToUnknowTestStep() {
        final TestStep parsed = AbstractTestStepParserTemplate.UNKNOWN.parse("any description");
        assertThat(parsed.actionType(), equalTo(UNKNOWN));
    }

    @Test
    public void nullObjectShouldNotHandleAnyDescriptions() {
        assertThat(AbstractTestStepParserTemplate.UNKNOWN.canHandle("any description"), is(false));
    }
}