package org.mrr.controls;

import org.junit.Test;
import org.mockito.Mockito;
import org.mrr.controls.api.ControlsRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControlsLogicImplTest {
    @Test
    public void whenLoadingCsvControls_shouldCallTheRepository() {
        final ControlsRepository repository = mock(ControlsRepository.class);
        final ControlsLogicImpl controlsLogic = new ControlsLogicImpl(repository);
        controlsLogic.loadControlsFromCsvFile();
        verify(repository).controls();
    }

    @Test
    public void whenLoadingControlsByName_shouldCallTheRepository() {
        final ControlsRepository repository = Mockito.mock(ControlsRepository.class);
        final ControlsLogicImpl controlsLogic = new ControlsLogicImpl(repository);
        controlsLogic.findControlByName("name");
        verify(repository).findControlByName("name");
    }
}
