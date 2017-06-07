package org.mrr;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.TestActionDescription.EMPTY;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class TestStepParserLogicImplParseTest {
    private static final String DESCRIPTION = "";

    @Mock
    private TestStepParserFactory factory;

    @Mock
    private ParseTestActionOperation stepParser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(factory.parserForDescription(DESCRIPTION)).thenReturn(stepParser);
        when(stepParser.actionFrom(DESCRIPTION)).thenReturn(new Action(CLICK_BUTTON, "button", ""));
    }

    @Test
    public void whenCreatingTestStep_shouldCallTheParserAgent() {
        final ParseTestActionLogic parseLogic = new DefaultParseTestActionLogic(factory);
        parseLogic.actionFromDescription(EMPTY);
        verify(factory).parserForDescription(EMPTY.description());
    }
}