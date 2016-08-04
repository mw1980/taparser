package org.mrr.controls;

import org.junit.Test;
import org.mrr.controls.api.ControlsRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControlsLogicImplTest {
    @Test
    public void whenLoadingCsvControls_shouldCallTheCsvRepository(){
        final ControlsRepository repository = mock(ControlsRepository.class);
        final ControlsLogicImpl controlsLogic = new ControlsLogicImpl(repository);
        controlsLogic.loadControlsFromCsvFile();
        verify(repository).controls();
    }
}
