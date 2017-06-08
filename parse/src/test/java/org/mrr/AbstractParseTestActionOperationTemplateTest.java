package org.mrr;

import org.junit.Test;
import org.mrr.core.domain.Action;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mrr.core.domain.ActionType.UNKNOWN;


public class AbstractParseTestActionOperationTemplateTest {
    @Test
    public void nullObjectShouldParseDescriptionToUnknowTestStep() {
        final Action parsed = AbstractParseTestActionOperationTemplate.UNKNOWN.actionFrom("any description");
        assertThat(parsed.actionType(), equalTo(UNKNOWN));
    }

    @Test
    public void nullObjectShouldNotHandleAnyDescriptions() {
        assertThat(AbstractParseTestActionOperationTemplate.UNKNOWN.canHandle("any description"), is(false));
    }
}