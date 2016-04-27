package org.mrr.controls;

import org.mrr.IdentificationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class translates a plain text description to a java control.
 */
class ControlsTranslator{
    private final List<String> descriptions;

    //TODO Validate the descriptions
    ControlsTranslator(final List<String> dscrption) {
        this.descriptions = dscrption;
    }

    Map<String, Control> translate() {
        final Map<String, Control> result = new HashMap<>();
        for (final String description : descriptions) {
            final String[] words = description.split(" ");
            result.put(name(words), control(words));
        }
        return result;
    }

    private String name(final String[] words){
        return words[0];
    }

    private Control control(final String[] words) {
        final String name = name(words);
        final IdentificationType type = IdentificationType.forValue(words[1]);
        final String value = words[2];
        return new Control(name, new Locator(type, value));
    }
}
