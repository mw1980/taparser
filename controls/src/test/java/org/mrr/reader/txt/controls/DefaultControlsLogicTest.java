package org.mrr.reader.txt.controls;

import org.junit.jupiter.api.Test;
import org.mrr.reader.txt.controls.api.ControlsRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DefaultControlsLogicTest {
    @Test
    void whenLoadingControls_shouldCallTheRepository() {
        final ControlsRepository repository = mock(ControlsRepository.class);
        final DefaultControlsLogic controlsLogic = new DefaultControlsLogic(repository);
        controlsLogic.allControls();
        verify(repository).controls();
    }

    @Test
    void whenLoadingControlsByName_shouldCallTheRepository() {
        final ControlsRepository repository = mock(ControlsRepository.class);
        final DefaultControlsLogic controlsLogic = new DefaultControlsLogic(repository);
        controlsLogic.controlWithName("name");
        verify(repository).controlWithName("name");
    }
}
