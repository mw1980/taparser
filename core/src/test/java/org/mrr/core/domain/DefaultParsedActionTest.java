package org.mrr.core.domain;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.DescribedAction;
import org.mrr.core.ParseActionLogic;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class DefaultParsedActionTest {

    @Mock
    private DescribedAction origin;

    @Mock
    private ParseActionLogic parseLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenParsingAction_shouldDelegateCallToDependencies() {
        when(origin.description()).thenReturn("");
        new DefaultParsedAction(origin, parseLogic).action();
        verifyZeroInteractions(origin);
        verify(parseLogic).actionFromDescription(origin);
    }
}