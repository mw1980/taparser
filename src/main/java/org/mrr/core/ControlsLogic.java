package org.mrr.core;

import org.mrr.controls.api.UiControl;

import java.util.Map;

/**
 * The class contains the methods needed to manage the user controls registered into the system.
 * The implementation of this interface is meant as the entry point for operating with the user interface
 * controls currently registered.
 */
public interface ControlsLogic {
    Map<String, UiControl> loadControlsFromCsvFile();
}
