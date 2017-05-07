package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.TestStepGenerateLogic;
import org.mrr.core.domain.TestStep;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestCaseGeneratorLogicImplTest {

    @Test
    public void whenGeneratingCode_shouldCallTheGeneratorFactory(){
        final CodeGeneratorFactory factory = mock(CodeGeneratorFactory.class);
        when(factory.codeGeneratorForTestStep(aTestStep())).thenReturn(mock(TestStepCodeGenerator.class));

        final TestStepGenerateLogic underTest = new TestStepGenerateLogicImpl(factory);
        underTest.automationCodeFor(aTestStep());

        verify(factory).codeGeneratorForTestStep(aTestStep());
    }

    private TestStep aTestStep() {
        return new TestStep(CLICK_BUTTON, "", "");
    }

    @Test
    public void whenGeneratingCode_shouldCallTheGenerator(){
        final CodeGeneratorFactory factory = mock(CodeGeneratorFactory.class);
        final TestStepCodeGenerator generate = mock(TestStepCodeGenerator.class);
        when(factory.codeGeneratorForTestStep(aTestStep())).thenReturn(generate);

        final TestStepGenerateLogic underTest = new TestStepGenerateLogicImpl(factory);
        underTest.automationCodeFor(aTestStep());

        verify(generate).generateCode(aTestStep());
    }
}