package org.mrr.reader.txt.controls;

import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.api.ControlsRepository;
import org.mrr.reader.txt.controls.api.ControlsSupplyAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.apache.commons.collections.MapUtils.isEmpty;

/**
 * Repository class for the controls registered to the application.
 * The class also implements a low level caching mechanism.
 */
@Component
class ControlsRepositoryImpl implements ControlsRepository {

    private final ControlsSupplyAgent supplyAgent;

    //low level caching.
    private Map<String, UiControl> controls;

    @Autowired
    public ControlsRepositoryImpl(final ControlsSupplyAgent controlsSupplyAgent) {
        this.supplyAgent = controlsSupplyAgent;
    }

    @Override
    public Map<String, UiControl> controls() {
        initControlsIfNeeded();
        return controls;
    }

    private void initControlsIfNeeded() {
        if (isEmpty(this.controls)) {
            this.controls = supplyAgent.supply();
        }
    }

    @Override
    public UiControl findControlByName(final String name) {
        initControlsIfNeeded();
        if (this.controls.containsKey(name)) {
            return this.controls.get(name);
        } else {
            return UiControl.NO_CONTROL;
        }
    }
}
