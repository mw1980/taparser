package org.mrr.reader.txt.controls.api;

import org.mrr.core.domain.UiControl;

import java.util.Map;

/**
 * Models the controls currently registered into the application.
 */
public interface RegisteredControls {
    /**
     * Returns a map consisting with key = user interface control names and value = user interface control.
     */
    Map<String, UiControl> all();
}
