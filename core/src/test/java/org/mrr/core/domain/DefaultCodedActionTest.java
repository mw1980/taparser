package org.mrr.core.domain;

import org.junit.jupiter.api.Test;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.ParsedAction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class DefaultCodedActionTest {

    private final ParsedAction origin = mock(ParsedAction.class);
    private CodeActionLogic codeLogic = mock(CodeActionLogic.class);

    @Test
    void shouldDelegateCallWhenDeliveringCodeForAction() {
        when(origin.action()).thenReturn(Action.EMPTY);

        final DefaultCodedAction underTest = new DefaultCodedAction(origin, codeLogic);

        underTest.code();
        verify(origin).action();
        verify(codeLogic).codeForAction(Action.EMPTY);
        verifyNoMoreInteractions(origin, codeLogic);
    }
}