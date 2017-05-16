package org.mrr.reader.txt.controls;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;
import org.mrr.reader.txt.controls.api.ControlsSupplyAgent;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

public class ControlsRepositoryImplTest {

    private static final String CONTROL_NAME = "name";

    @Mock
    private ControlsSupplyAgent supplyAgent;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenAskingForControls_shouldCallTheControlsAgent(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        repository.controls();
        verify(supplyAgent).supply();
    }

    @Test
    public void whenAskingForControls_shouldCashTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        when(supplyAgent.supply()).thenReturn(notEmptyControlsMap());
        //the second call should return the cached values, not call the controls supplyAgent for the second time.
        repository.controls();
        repository.controls();
        verify(supplyAgent).supply();
    }

    private Map<String, UiControl> notEmptyControlsMap() {
        return singletonMap(CONTROL_NAME, notEmptyControl());
    }

    private UiControl notEmptyControl() {
        return new UiControl(CONTROL_NAME, new UiLocator(ID, "nameHtmlId"));
    }

    @Test
    public void whenSearchingForControlByName_shouldCallTheControlsSupplyDelegate() {
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        repository.findControlByName("");
        verify(supplyAgent).supply();
    }

    @Test
    public void whenSearchingForControlByName_shouldCacheTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        when(supplyAgent.supply()).thenReturn(notEmptyControlsMap());
        repository.findControlByName("");
        repository.findControlByName("");
        verify(supplyAgent).supply();
    }

    @Test
    public void whenControlNoFound_shouldReturnTheNoControlUiObject(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        assertThat(
                NO_CONTROL,
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }

    @Test
    public void whenSearchingForAvailableObject_shouldReturnCorrectObject(){
        when(supplyAgent.supply()).thenReturn(notEmptyControlsMap());
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyAgent);
        assertThat(
                notEmptyControl(),
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }
}