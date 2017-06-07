package org.mrr;

import org.junit.Test;
import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestCaseGeneratorLogicImplTest {

    @Test
    public void whenGeneratingCode_shouldCallTheGeneratorFactory() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        when(factory.generateCodeOperationFor(aTestStep())).thenReturn(mock(CodeTestActionOperation.class));

        final CodeTestActionLogic underTest = new DefaultCodeTestActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(factory).generateCodeOperationFor(aTestStep());
    }

    private Action aTestStep() {
        return new Action(CLICK_BUTTON, "", "");
    }

    @Test
    public void whenGeneratingCode_shouldCallTheGenerator() {
        final DefaultCodeFactory factory = mock(DefaultCodeFactory.class);
        final CodeTestActionOperation generate = mock(CodeTestActionOperation.class);
        when(factory.generateCodeOperationFor(aTestStep())).thenReturn(generate);

        final CodeTestActionLogic underTest = new DefaultCodeTestActionLogic(factory);
        underTest.codeForAction(aTestStep());

        verify(generate).codeFor(aTestStep());
    }
}