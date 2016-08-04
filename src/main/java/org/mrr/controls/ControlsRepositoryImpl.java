package org.mrr.controls;

import org.mrr.controls.api.ControlsSupplyAgent;
import org.mrr.controls.api.ControlsRepository;
import org.mrr.controls.api.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository class for the controls registered to the application.
 * The class also implements a low level caching mechanism.
 */
@Component
class ControlsRepositoryImpl implements ControlsRepository {

    private final ControlsSupplyAgent agent;

    //low level caching.
    private Map<String, UiControl> controls;

    @Autowired
    public ControlsRepositoryImpl(final ControlsSupplyAgent agent) {
        this.controls = new HashMap<>();
        this.agent = agent;
    }

    @Override
    public Map<String, UiControl> controls() {
        initControlsIfNeeded();
        return controls;
    }

    private void initControlsIfNeeded() {
        if (noControlsAvailable()) {
            this.controls = agent.supply();
        }
    }

    private boolean noControlsAvailable() {
        return this.controls.isEmpty();
    }

    @Override
    public UiControl searchControlByName(final String name) {
        initControlsIfNeeded();
        if (this.controls.containsKey(name)) {
            return this.controls.get(name);
        } else {
            return UiControl.NO_CONTROL;
        }
    }
}
