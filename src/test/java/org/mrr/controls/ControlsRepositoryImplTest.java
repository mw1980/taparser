package org.mrr.controls;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.controls.api.ControlsAgent;
import org.mrr.controls.api.UiControl;
import org.mrr.controls.api.UiLocator;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.IdentificationCriteria.ID;

public class ControlsRepositoryImplTest {

    private static final String CONTROL_NAME = "name";

    @Mock
    private ControlsAgent agent;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenAskingForControls_shouldCallTheControlsAgent(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        repository.controls();
        verify(agent).supply();
    }

    @Test
    public void whenAskingForControls_shouldCashTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        when(agent.supply()).thenReturn(notEmptyControlsMap());
        //the second call should return the cached values, not call the controls agent for the second time.
        repository.controls();
        repository.controls();
        verify(agent).supply();
    }

    private Map<String, UiControl> notEmptyControlsMap() {
        return singletonMap(CONTROL_NAME, notEmptyControl());
    }

    private UiControl notEmptyControl() {
        return new UiControl(CONTROL_NAME, new UiLocator(ID, "nameTF"));
    }

    @Test
    public void whenSearchingForControlByName_shouldCallTheControlsAgent(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        repository.searchControlByName("");
        verify(agent).supply();
    }

    @Test
    public void whenSearchingForControlByName_shouldCacheTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        when(agent.supply()).thenReturn(notEmptyControlsMap());
        repository.searchControlByName("");
        repository.searchControlByName("");
        verify(agent).supply();
    }

    @Test
    public void whenControlNoFound_shouldReturnTheNoControlUiObject(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        assertThat(
                UiControl.NO_CONTROL,
                equalTo(repository.searchControlByName("name")));
    }

    @Test
    public void whenSearchingForAvailableObject_shouldReturnCorrectObject(){
        when(agent.supply()).thenReturn(notEmptyControlsMap());
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.agent);
        assertThat(
                notEmptyControl(),
                equalTo(repository.searchControlByName(CONTROL_NAME)));
    }
}