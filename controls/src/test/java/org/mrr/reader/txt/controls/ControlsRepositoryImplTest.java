package org.mrr.reader.txt.controls;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;
import org.mrr.reader.txt.controls.api.RegisteredControls;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

public class ControlsRepositoryImplTest {

    private static final String CONTROL_NAME = "name";

    @Mock
    private RegisteredControls registered;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        reset(registered);
    }

    @Test
    public void whenAskingForControls_shouldLoadFromRegisteredControls() {
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        repository.controls();
        verify(registered).all();
    }

    @Test
    public void whenAskingForControls_shouldCashTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        when(registered.all()).thenReturn(notEmptyControlsMap());
        //the second call should return the cached values, not call the controls supplyAgent for the second time.
        repository.controls();
        repository.controls();
        verify(registered).all();
    }

    private Map<String, UiControl> notEmptyControlsMap() {
        return singletonMap(CONTROL_NAME, notEmptyControl());
    }

    private UiControl notEmptyControl() {
        return new UiControl(CONTROL_NAME, new UiLocator(ID, "nameHtmlId"));
    }

    @Test
    public void whenSearchingForControlByName_shouldCallTheControlsSupplyDelegate() {
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        repository.findControlByName("");
        verify(registered).all();
    }

    @Test
    public void whenSearchingForControlByName_shouldCacheTheResult(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        when(registered.all()).thenReturn(notEmptyControlsMap());
        repository.findControlByName("");
        repository.findControlByName("");
        verify(registered).all();
    }

    @Test
    public void whenControlNoFound_shouldReturnTheNoControlUiObject(){
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        assertThat(
                NO_CONTROL,
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }

    @Test
    public void whenSearchingForAvailableObject_shouldReturnCorrectObject(){
        when(registered.all()).thenReturn(notEmptyControlsMap());
        final ControlsRepositoryImpl repository = new ControlsRepositoryImpl(this.registered);
        assertThat(
                notEmptyControl(),
                equalTo(repository.findControlByName(CONTROL_NAME)));
    }
}