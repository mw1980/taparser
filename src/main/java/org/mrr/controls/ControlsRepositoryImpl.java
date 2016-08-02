package org.mrr.controls;

import org.mrr.controls.api.ControlsAgent;
import org.mrr.controls.api.ControlsRepository;
import org.mrr.controls.api.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The class stores the controls registered for the current application.
 * //TODO: caching here still missing.
 */
@Component
public class ControlsRepositoryImpl implements ControlsRepository {

    private final ControlsAgent agent;

    @Autowired
    public ControlsRepositoryImpl(final ControlsAgent agent) {
        this.agent = agent;
    }

    @Override
    public Map<String, UiControl> controls() {
        return agent.supply();
    }

    @Override
    public UiControl searchControlByName(final String name) {
        final Map<String, UiControl> controls = agent.supply();
        if (controls.containsKey(name)) {
            return controls.get(name);
        } else {
            return UiControl.NO_CONTROL;
        }
    }
}
