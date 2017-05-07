package org.mrr.controls.api;

import org.mrr.core.domain.UiControl;

import java.util.Map;

/**
 * The interface declares the contract for the classes that deliver user interface control objects.
 */
public interface ControlsSupplyAgent {
    /**
     * Returns the registered user interface controls.
     * @return a map that contains the control names as keys and the ui controls as values.
     */
    Map<String, UiControl> supply();
}
