package org.mrr.controls.api;

import java.util.List;
import java.util.Map;

/**
 * Translator class. Contains methods to parse control data description to ui control object.
 */
public interface TranslateControlsStrategy {
    Map<String, UiControl> translate(List<String> description);
}
