package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.TestStepGeneratorLogic;
import org.mrr.core.domain.TestStep;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestCaseGeneratorLogicImplTest {

    @Test
    public void whenGeneratingCode_shouldCallTheGeneratorFactory(){
        final TestStep testStep = new TestStep(CLICK_BUTTON, "", "");
        final CodeGeneratorFactory factoryMock = mock(CodeGeneratorFactory.class);
        when(factoryMock.codeGeneratorForTestStep(testStep)).thenReturn(mock(TestStepCodeGenerator.class));

        final TestStepGeneratorLogic generatorLogic = new TestStepGeneratorLogicImpl(factoryMock);
        generatorLogic.automationCodeFor(testStep);

        verify(factoryMock).codeGeneratorForTestStep(testStep);
    }

    @Test
    public void whenGeneratingCode_shouldCallTheGenerator(){
        final TestStep testStep = new TestStep(CLICK_BUTTON, "", "");
        final CodeGeneratorFactory factoryMock = mock(CodeGeneratorFactory.class);
        final TestStepCodeGenerator generatorMock = mock(TestStepCodeGenerator.class);
        when(factoryMock.codeGeneratorForTestStep(testStep)).thenReturn(generatorMock);

        final TestStepGeneratorLogic generatorLogic = new TestStepGeneratorLogicImpl(factoryMock);
        generatorLogic.automationCodeFor(testStep);
    }
}