package org.mrr.controls;

import org.mrr.controls.api.ControlsRepository;
import org.mrr.core.ControlsLogic;
import org.mrr.core.domain.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class ControlsLogicImpl implements ControlsLogic {

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
