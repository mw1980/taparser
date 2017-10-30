package org.mrr.core.domain;


import org.junit.jupiter.api.Test;
import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

class DefaultParsedActionTest {

    private final DescribedAction origin = mock(DescribedAction.class);
    private final ParseActionLogic parseLogic = mock(ParseActionLogic.class);

    @Test
    void whenParsingAction_shouldDelegateCallToDependencies() {
        when(origin.description()).thenReturn("");
        final DefaultParsedAction underTest = new DefaultParsedAction(origin, parseLogic);

        underTest.action();

        verifyZeroInteractions(origin);
        verify(parseLogic).actionFromDescription(origin);
    }
}