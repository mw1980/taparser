package org.mrr.reader.txt.controls;

import org.junit.Test;
import org.mrr.reader.txt.controls.api.ControlsRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControlsLogicImplTest {
    @Test
    public void whenLoadingControls_shouldCallTheRepository() {
        final ControlsRepository repository = mock(ControlsRepository.class);
        final ControlsLogicImpl controlsLogic = new ControlsLogicImpl(repository);
        controlsLogic.allControls();
        verify(repository).controls();
    }

    @Test
    public void whenLoadingControlsByName_shouldCallTheRepository() {
        final ControlsRepository repository = mock(ControlsRepository.class);
        final ControlsLogicImpl controlsLogic = new ControlsLogicImpl(repository);
        controlsLogic.controlWithName("name");
        verify(repository).findControlByName("name");
    }
}
