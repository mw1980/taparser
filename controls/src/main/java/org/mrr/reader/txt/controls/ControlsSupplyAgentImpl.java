package org.mrr.reader.txt.controls;

import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.api.ControlsSupplyAgent;
import org.mrr.reader.txt.controls.api.LoadDescriptionsStrategy;
import org.mrr.reader.txt.controls.api.TranslateControlsDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Controls supply class, loads the control descriptions from external resource and parse them to UiControls map.
 */
@Component
public class ControlsSupplyAgentImpl implements ControlsSupplyAgent {
    private final LoadDescriptionsStrategy loadStrategy;
    private final TranslateControlsDelegate translateDelegate;

    @Autowired
    public ControlsSupplyAgentImpl(final LoadDescriptionsStrategy loadStrategy,
                                   final TranslateControlsDelegate translateDelegate) {
        this.loadStrategy = loadStrategy;
        this.translateDelegate = translateDelegate;
    }

    /**
     * Returns the controls defined in the external source.
     *
     * @return map of controls. The keys are the control names.
     */
    @Override
    public Map<String, UiControl> supply() {
        final List<String> descriptions = loadStrategy.loadDescriptions();
        return translateDelegate.translate(descriptions);
    }
}
