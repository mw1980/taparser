package org.mrr.controls;

import org.mrr.controls.api.TranslateControlsDelegate;
import org.mrr.core.domain.IdentificationCriteria;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class translates a plain description descriptions to a java control.
 */

@Component
class CsvTranslateControlsDelegate implements TranslateControlsDelegate {

    @Override
    public Map<String, UiControl> translate(final List<String> descriptions) {
        final Map<String, UiControl> result = new HashMap<>();
        for (final String description : descriptions) {
            final String[] words = description.split(" ");
            result.put(name(words), control(words));
        }
        return result;
    }

    private String name(final String[] words){
        return words[0];
    }

    private UiControl control(final String[] words) {
        final String name = name(words);
        final IdentificationCriteria type = IdentificationCriteria.forValue(words[1]);
        final String value = words[2];
        return new UiControl(name, new UiLocator(type, value));
    }
}
