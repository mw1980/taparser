package org.mrr.core;

import org.mrr.core.domain.UiControl;

import java.util.Map;

/**
 * The class contains the methods needed to manage the user controls registered into the system.
 */
public interface ControlsLogic {
    /**
     * Loads the controls defined in an external source.
     *
     * @return Controls map with control names as key and UiControl objects as values.
     */
    Map<String, UiControl> allControls();

    /**
     * Search control by name.
     * Returns the found object, if available, or a default object.
     */
    UiControl controlWithName(String name);
}
