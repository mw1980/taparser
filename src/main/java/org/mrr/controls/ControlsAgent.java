package org.mrr.controls;

import java.util.Map;

/**
 * The interface declares the contract for the classes that deliver control objects.
 */
interface ControlsAgent {
    Map<String, Control> supply();
}
