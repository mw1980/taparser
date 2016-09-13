package org.mrr.controls;

import org.mrr.controls.api.ControlsSupplyDelegate;
import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.mrr.controls.api.TranslateControlsDelegate;
import org.mrr.core.domain.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Controls supply class, loads the control descriptions from external resource and parse them to UiControls map.
 */
@Component
class ControlsSupplyDelegateImpl implements ControlsSupplyDelegate {
    private final LoadDescriptionsStrategy loadStrategy;
    private final TranslateControlsDelegate translateDelegate;

    @Autowired
    public ControlsSupplyDelegateImpl(final LoadDescriptionsStrategy loadStrategy,
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
