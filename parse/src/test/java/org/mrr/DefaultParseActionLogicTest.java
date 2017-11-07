package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mrr.core.DescribedAction.EmptyDescribedAction;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

class DefaultParseActionLogicTest {

    private final ParseActionFactory factory = mock(ParseActionFactory.class);
    private final ParseActionOperation parseOperation = mock(ParseActionOperation.class);

    @Test
    void whenParsingAction_shouldLoadTheParseOperationOverTheFactory() {
        final DescribedAction empty = new EmptyDescribedAction();
        when(factory.parseOperationForDescription(empty.description())).thenReturn(parseOperation);
        when(parseOperation.actionFor(empty.description())).thenReturn(Action.withType(CLICK_BUTTON));

        final ParseActionLogic underTest = new DefaultParseActionLogic(factory);
        underTest.actionFromDescription(empty);

        verify(factory).parseOperationForDescription(empty.description());
        verify(parseOperation).actionFor(empty.description());
        verifyNoMoreInteractions(factory, parseOperation);
    }
}