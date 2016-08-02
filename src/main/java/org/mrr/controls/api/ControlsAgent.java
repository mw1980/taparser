package org.mrr.controls.api;

import java.util.Map;

/**
 * The interface declares the contract for the classes that deliver user interface control objects.
 */
public interface ControlsAgent {
    /**
     * Returns the user interface controls currently registered into the system.
     * @return a map that contains the control names as keys and the ui controls as values.
     */
    Map<String, UiControl> supply();
}
