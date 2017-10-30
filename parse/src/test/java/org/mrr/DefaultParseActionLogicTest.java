package org.mrr;

import org.junit.Test;
import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.DescribedAction.EmptyDescribedAction;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class DefaultParseActionLogicTest {
    private static final String DESCRIPTION = "";

    private final ParseActionFactory factory = mock(ParseActionFactory.class);
    private final ParseActionOperation stepParser = mock(ParseActionOperation.class);

    @Test
    public void whenParsingAction_shouldLoadTheParseOperationOverTheFactory() {
        final DescribedAction empty = new EmptyDescribedAction();
        when(factory.parseOperationFromDescription(DESCRIPTION)).thenReturn(stepParser);
        when(stepParser.actionFrom(DESCRIPTION)).thenReturn(new Action(CLICK_BUTTON, "button", ""));
        final ParseActionLogic underTest = new DefaultParseActionLogic(factory);
        underTest.actionFromDescription(empty);
        verify(factory).parseOperationFromDescription(empty.description());
    }
}