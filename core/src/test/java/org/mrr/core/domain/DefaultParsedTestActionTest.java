package org.mrr.core.domain;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.TestActionDescription;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class DefaultParsedTestActionTest {

    @Mock
    private TestActionDescription origin;

    @Mock
    private ParseTestActionLogic parseLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenParsingTestAction_shouldDelegateCallToDependencies() {
        when(origin.description()).thenReturn("");
        new DefaultParsedTestAction(origin, parseLogic).action();
        verifyZeroInteractions(origin);
        verify(parseLogic).actionFromDescription(origin);
    }
}