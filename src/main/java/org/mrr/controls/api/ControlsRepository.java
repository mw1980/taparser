package org.mrr.controls.api;

import java.util.Map;

/**
 * The controls repository api.
 * Defined the methods provided to operate on the set of user interface controls registered in the application.
 */
public interface ControlsRepository {

    /**
     * Delivers all the controls registered to the current application as a map.
     * The Keys are control names.
     */
    Map<String, UiControl> controls();

    /**
     * Searches the control with the given name.
     * @return The UiControl, if found, or standard not null UiControl otherwise.
     */
    UiControl searchControlByName(String name);
}