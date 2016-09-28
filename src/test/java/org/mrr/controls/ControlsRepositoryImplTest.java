package org.mrr.controls;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.controls.api.ControlsSupplyDelegate;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;

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
    private ControlsSupplyDelegate supplyDelegate;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenAskingForControls_shouldCallTheControlsAgent(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        repository.controls();
        verify(supplyDelegate).supply();
    }

    @Test
    public void whenAskingForControls_shouldCashTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        when(supplyDelegate.supply()).thenReturn(notEmptyControlsMap());
        //the second call should return the cached values, not call the controls supplyDelegate for the second time.
        repository.controls();
        repository.controls();
        verify(supplyDelegate).supply();
    }

    private Map<String, UiControl> notEmptyControlsMap() {
        return singletonMap(CONTROL_NAME, notEmptyControl());
    }

    private UiControl notEmptyControl() {
        return new UiControl(CONTROL_NAME, new UiLocator(ID, "nameHtmlId"));
    }

    @Test
    public void whenSearchingForControlByName_shouldCallTheControlsSupplyDelegate() {
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        repository.findControlByName("");
        verify(supplyDelegate).supply();
    }

    @Test
    public void whenSearchingForControlByName_shouldCacheTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        when(supplyDelegate.supply()).thenReturn(notEmptyControlsMap());
        repository.findControlByName("");
        repository.findControlByName("");
        verify(supplyDelegate).supply();
    }

    @Test
    public void whenControlNoFound_shouldReturnTheNoControlUiObject(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        assertThat(
                NO_CONTROL,
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }

    @Test
    public void whenSearchingForAvailableObject_shouldReturnCorrectObject(){
        when(supplyDelegate.supply()).thenReturn(notEmptyControlsMap());
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.supplyDelegate);
        assertThat(
                notEmptyControl(),
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }
}