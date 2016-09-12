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
 * Controls delivery agent, that gets the controls from an csv file.
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
     * Returns the list of controls defined in the external csv file at the current location.
     *
     * @return List of controls.
     */
    @Override
    public Map<String, UiControl> supply() {
        final List<String> descriptions = loadStrategy.loadDescriptions();
        return translateDelegate.translate(descriptions);
    }
}
