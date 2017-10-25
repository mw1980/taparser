package org.mrr.reader.txt.controls;

import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.IdentificationCriteria;
import org.mrr.core.domain.UiControl;
import org.mrr.core.domain.UiLocation;
import org.mrr.reader.txt.controls.api.ControlDescriptions;
import org.mrr.reader.txt.controls.api.RegisteredControls;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

/**
 * The class implements the translation logic from controls plain text descriptions to java controls.
 */

@Component
class CsvRegisteredControls implements RegisteredControls {
    private static final String SEPARATOR = " ";

    private final ControlDescriptions descriptions;

    CsvRegisteredControls(final ControlDescriptions controlsDescriptions) {
        this.descriptions = controlsDescriptions;
    }

    @Override
    public Map<String, UiControl> allRegistered() {
        return descriptions.allDescriptions().stream()
                .map(description -> description.split(SEPARATOR))
                .collect(toMap(this::name, this::control));
    }

    private String name(final String[] words) {
        return words[0];
    }

    //the words are expected in this form: words[0] = name, words[1] = identification type, words[2] = identification value
    private UiControl control(final String[] words) {
        final String name = name(words);
        final IdentificationCriteria type = Stream.of(IdentificationCriteria.values())
                .filter(identificationCriteria -> identificationCriteria.matchesDescription(words[1]))
                .findAny()
                .orElseThrow(() -> new LoadControlsException(format("Cannot find a identification criteria for %s.", words[1])));
        final String value = words[2];
        return new UiControl(name, new UiLocation(type, value));
    }
}
