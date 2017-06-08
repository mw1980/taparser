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

public class DefaultParseTestActionLogicTest {
    private static final String DESCRIPTION = "";

    @Mock
    private ParseTestActionFactory factory;

    @Mock
    private ParseTestActionOperation stepParser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCreatingTestStep_shouldCallTheParserAgent() {
        when(factory.parseOperationFromDescription(DESCRIPTION)).thenReturn(stepParser);
        when(stepParser.actionFrom(DESCRIPTION)).thenReturn(new Action(CLICK_BUTTON, "button", ""));
        final ParseTestActionLogic underTest = new DefaultParseTestActionLogic(factory);
        underTest.actionFromDescription(EMPTY);
        verify(factory).parseOperationFromDescription(EMPTY.description());
    }
}