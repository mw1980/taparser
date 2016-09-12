package org.mrr.controls.api;

import org.mrr.core.domain.UiControl;

import java.util.List;
import java.util.Map;

/**
 * Translator class. Contains methods to parse control data description to ui control object.
 */
public interface TranslateControlsDelegate {
    /**
     * Returns a map consisting with key = user interface control names and value = user interface control.
     */
    Map<String, UiControl> translate(List<String> description);
}
