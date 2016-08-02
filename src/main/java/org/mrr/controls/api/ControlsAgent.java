package org.mrr.controls.api;

import java.util.Map;

/**
 * The interface declares the contract for the classes that deliver user interface control objects.
 */
public interface ControlsAgent {
    Map<String, UiControl> supply();
}
