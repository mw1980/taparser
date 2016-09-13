package org.mrr.controls.api;

import org.mrr.core.domain.UiControl;

import java.util.List;
import java.util.Map;

/**
 * Defines the methods to parse control data descriptions to ui control objects.
 */
public interface TranslateControlsDelegate {
    /**
     * Returns a map consisting with key = user interface control names and value = user interface control.
     */
    Map<String, UiControl> translate(List<String> description);
}
