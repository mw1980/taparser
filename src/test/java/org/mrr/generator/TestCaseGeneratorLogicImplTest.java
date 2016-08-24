package org.mrr.generator;

import org.junit.Test;
import org.mrr.core.TestCaseGeneratorLogic;
import org.mrr.core.domain.TestStep;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestCaseGeneratorLogicImplTest {

    @Test
    public void whenGeneratingCode_shouldCallTheGeneratorFactory(){
        final TestStep testStep = new TestStep(CLICK_BUTTON, "", "");
        final GenerateCodeFactory factoryMock = mock(GenerateCodeFactory.class);
        when(factoryMock.findGenerator(testStep)).thenReturn(mock(TestCaseCodeGenerator.class));

        final TestCaseGeneratorLogic generatorLogic = new TestCaseGeneratorLogicImpl(factoryMock);
        generatorLogic.generateCode(testStep);

        verify(factoryMock).findGenerator(testStep);
    }

    @Test
    public void whenGeneratingCode_shouldCallTheGenerator(){
        final TestStep testStep = new TestStep(CLICK_BUTTON, "", "");
        final GenerateCodeFactory factoryMock = mock(GenerateCodeFactory.class);
        final TestCaseCodeGenerator generatorMock = mock(TestCaseCodeGenerator.class);
        when(factoryMock.findGenerator(testStep)).thenReturn(generatorMock);

        final TestCaseGeneratorLogic generatorLogic = new TestCaseGeneratorLogicImpl(factoryMock);
        generatorLogic.generateCode(testStep);
    }
}