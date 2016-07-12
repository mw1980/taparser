package org.mrr.controls;

import java.util.Map;

/**
 * The class stores the controls registered for the current application.
 */
public class ControlsRepositoryImpl implements ControlsRepository {

    private final ControlsAgent agent;

    public ControlsRepositoryImpl(final ControlsAgent agent) {
        this.agent = agent;
    }

    @Override
    public Map<String, UiControl> controls() {
        return agent.supply();
    }

    @Override
    public UiControl searchControlByName(final String name) {
        //FIXME caching mechanism missing
        final Map<String, UiControl> controls = agent.supply();
        if (controls.containsKey(name)) {
            return controls.get(name);
        } else {
            return UiControl.NO_CONTROL;
        }
    }
}
