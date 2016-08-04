package org.mrr.controls;

import org.mrr.controls.api.ControlsSupplyAgent;
import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.mrr.controls.api.TranslateControlsStrategy;
import org.mrr.controls.api.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Controls delivery agent, that gets the controls from an csv file.
 */
@Component
class ControlsSupplyAgentImpl implements ControlsSupplyAgent {
    private final LoadDescriptionsStrategy loadStrategy;
    private final TranslateControlsStrategy translateStrategy;

    @Autowired
    public ControlsSupplyAgentImpl(final LoadDescriptionsStrategy loadStrategy,
                                   final TranslateControlsStrategy translateStrategy) {
        this.loadStrategy = loadStrategy;
        this.translateStrategy = translateStrategy;
    }

    /**
     * Returns the list of controls defined in the external csv file at the current location.
     *
     * @return List of controls.
     */
    @Override
    public Map<String, UiControl> supply() {
        final List<String> descriptions = loadStrategy.descriptionsAsText();
        return translateStrategy.translate(descriptions);
    }
}
