package org.mrr.parser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.TestStepParseLogic;
import org.mrr.core.domain.TestStep;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestStepParserLogicImplTest {
    private static final String DESCRIPTION = "Click Button myButton";

    @Mock
    private TestStepParserFactory factory;

    @Mock
    private TestStepParser stepParser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(factory.parserForDescription(DESCRIPTION)).thenReturn(stepParser);
        when(stepParser.parse(DESCRIPTION)).thenReturn(new TestStep(CLICK_BUTTON, "button", ""));
    }

    @Test
    public void whenCreatingTestStep_shouldCallTheParserAgent() {
        final TestStepParseLogic parseLogic = new TestStepParseLogicImpl(factory);
        parseLogic.testStepForDescription(DESCRIPTION);
        verify(factory).parserForDescription(DESCRIPTION);
    }
}