package org.mrr.core.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.ParsedTestAction;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultCodedTestActionTest {

    @Mock
    private ParsedTestAction origin;

    @Mock
    private CodeTestActionLogic codeLogic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenDeliveringAutomationCode_shouldCallInnerMethods() {
        when(origin.action()).thenReturn(Action.EMPTY);
        new DefaultCodedTestAction(origin, codeLogic).code();
        verify(origin).action();
        verify(codeLogic).codeForAction(Action.EMPTY);
    }
}