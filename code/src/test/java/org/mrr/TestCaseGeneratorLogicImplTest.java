package org.mrr;

import org.junit.Test;
import org.mrr.api.GenerateActionCodeOperation;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestCaseGeneratorLogicImplTest {

    @Test
    public void whenGeneratingCode_shouldCallTheGeneratorFactory() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        when(factory.codeGenerationOperationFor(aTestStep())).thenReturn(mock(GenerateActionCodeOperation.class));

        final CodeActionLogic underTest = new DefaultCodeActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(factory).codeGenerationOperationFor(aTestStep());
    }

    private Action aTestStep() {
        return new Action(CLICK_BUTTON, "", "");
    }

    @Test
    public void whenGeneratingCode_shouldCallTheGenerator() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        final GenerateActionCodeOperation generate = mock(GenerateActionCodeOperation.class);
        when(factory.codeGenerationOperationFor(aTestStep())).thenReturn(generate);

        final CodeActionLogic underTest = new DefaultCodeActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(generate).codeFor(aTestStep());
    }
}