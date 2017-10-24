package org.mrr.core.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.ParsedAction;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultCodedActionTest {

    @Mock
    private ParsedAction origin;

    @Mock
    private CodeActionLogic codeLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenDeliveringAutomationCode_shouldCallInnerMethods() {
        when(origin.action()).thenReturn(Action.EMPTY);
        new DefaultCodedAction(origin, codeLogic).code();
        verify(origin).action();
        verify(codeLogic).codeForAction(Action.EMPTY);
    }
}