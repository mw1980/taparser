package org.mrr.controls;

import org.mrr.controls.api.ControlsRepository;
import org.mrr.controls.api.ControlsSupplyDelegate;
import org.mrr.core.domain.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Repository class for the controls registered to the application.
 * The class also implements a low level caching mechanism.
 */
@Component
class ControlsRepositoryImpl implements ControlsRepository {

    private final ControlsSupplyDelegate supplyDelegate;

    //low level caching.
    private Map<String, UiControl> controls;

    @Autowired
    public ControlsRepositoryImpl(final ControlsSupplyDelegate supplyDelegate) {
        this.supplyDelegate = supplyDelegate;
    }

    @Override
    public Map<String, UiControl> controls() {
        initControlsIfNeeded();
        return controls;
    }

    private void initControlsIfNeeded() {
        if (controlsUnavailable()) {
            this.controls = supplyDelegate.supply();
        }
    }

    private boolean controlsUnavailable() {
        return this.controls == null || this.controls.isEmpty();
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
