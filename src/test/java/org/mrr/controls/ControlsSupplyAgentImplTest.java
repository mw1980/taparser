package org.mrr.controls;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.mrr.controls.api.TranslateControlsStrategy;

import java.util.Collections;

import static org.mockito.Mockito.verify;

public class ControlsSupplyAgentImplTest {

    @Mock
    private LoadDescriptionsStrategy loadStrategy;

    @Mock
    private TranslateControlsStrategy translateStrategy;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCallingSupply_shouldDelegateCallToLoadDescriptionStrategy(){
        final ControlsSupplyAgentImpl agent = new ControlsSupplyAgentImpl(this.loadStrategy, this.translateStrategy);
        agent.supply();
        verify(loadStrategy).descriptionsAsText();
    }

    @Test
    public void whenCallingSupply_shouldDelegateCallToTranslateDescriptionStrategy(){
        final ControlsSupplyAgentImpl agent = new ControlsSupplyAgentImpl(this.loadStrategy, this.translateStrategy);
        agent.supply();
        verify(translateStrategy).translate(Collections.<String>emptyList());
    }
}