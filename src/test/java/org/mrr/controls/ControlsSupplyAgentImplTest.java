package org.mrr.controls;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.mrr.controls.api.TranslateControlsDelegate;

import java.util.Collections;

import static org.mockito.Mockito.verify;

public class ControlsSupplyAgentImplTest {

    @Mock
    private LoadDescriptionsStrategy loadStrategy;

    @Mock
    private TranslateControlsDelegate translateStrategy;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCallingSupply_shouldDelegateCallToLoadDescriptionStrategy(){
        final ControlsSupplyAgentImpl agent = new ControlsSupplyAgentImpl(this.loadStrategy, this.translateStrategy);
        agent.supply();
        verify(loadStrategy).loadDescriptions();
    }

    @Test
    public void whenCallingSupply_shouldDelegateCallToTranslateDescriptionStrategy(){
        final ControlsSupplyAgentImpl controlsDelegate = new ControlsSupplyAgentImpl(this.loadStrategy, this.translateStrategy);
        controlsDelegate.supply();
        verify(translateStrategy).translate(Collections.emptyList());
    }
}