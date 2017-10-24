package org.mrr;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.domain.Action;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.DescribedAction.EMPTY;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

public class DefaultParseActionLogicTest {
    private static final String DESCRIPTION = "";

    @Mock
    private ParseActionFactory factory;

    @Mock
    private ParseActionOperation stepParser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCreatingTestStep_shouldCallTheParserAgent() {
        when(factory.parseOperationFromDescription(DESCRIPTION)).thenReturn(stepParser);
        when(stepParser.actionFrom(DESCRIPTION)).thenReturn(new Action(CLICK_BUTTON, "button", ""));
        final ParseActionLogic underTest = new DefaultParseActionLogic(factory);
        underTest.actionFromDescription(EMPTY);
        verify(factory).parseOperationFromDescription(EMPTY.description());
    }
}