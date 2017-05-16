package org.mrr.reader.txt.controls;

import org.mrr.core.ControlsLogic;
import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.api.ControlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ControlsLogicImpl implements ControlsLogic {

    private final ControlsRepository controlsRepository;

    @Autowired
    public ControlsLogicImpl(final ControlsRepository repository) {
        this.controlsRepository = repository;
    }

    @Override
    public Map<String, UiControl> allControls() {
        return controlsRepository.controls();
    }

    @Override
    public UiControl controlWithName(final String name) {
        return controlsRepository.findControlByName(name);
    }
}
