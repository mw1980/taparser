package org.mrr.controls;

import org.mrr.controls.api.ControlsRepository;
import org.mrr.controls.api.UiControl;
import org.mrr.core.ControlsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class ControlsLogicImpl implements ControlsLogic {

    private final ControlsRepository csvRepository;

    @Autowired
    public ControlsLogicImpl(final ControlsRepository csvRepository) {
        this.csvRepository = csvRepository;
    }

    @Override
    public Map<String, UiControl> loadControlsFromCsvFile() {
        return csvRepository.controls();
    }
}
