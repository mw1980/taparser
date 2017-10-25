package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.api.CodedOperation;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

class DefaultCodeActionLogicTest {

    @Test
    void whenGeneratingCode_shouldCallTheGeneratorFactory() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        when(factory.codedOperationFor(aTestStep())).thenReturn(mock(CodedOperation.class));

        final CodeActionLogic underTest = new DefaultCodeActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(factory).codedOperationFor(aTestStep());
    }

    private Action aTestStep() {
        return Action.withType(CLICK_BUTTON);
    }

    @Test
    void whenGeneratingCode_shouldCallTheGenerator() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        final CodedOperation generate = mock(CodedOperation.class);
        when(factory.codedOperationFor(aTestStep())).thenReturn(generate);

        final CodeActionLogic underTest = new DefaultCodeActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(generate).codeFor(aTestStep());
    }
}