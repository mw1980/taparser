package org.mrr.controls;

import org.mrr.ReadSpecificationException;
import org.mrr.controls.api.ControlsAgent;
import org.mrr.controls.api.UiControl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * Controls delivery agent, that gets the controls from an csv file.
 */
public class ControlsCsvAgent implements ControlsAgent {
    /**
     * Location of the csv file that contains the controls descriptions.
     */
    private final String location;

    public ControlsCsvAgent(final String location) {
        this.location = location;
    }

    /**
     * Returns the list of controls defined in the external csv file at the current location.
     * @return List of controls.
     * @throws ReadSpecificationException if the ui elements description cannot be read.
     */
    public Map<String, UiControl> supply() {
        try {
            //TODO: read lines over a injected bean. It shpould be easier to test.
            final List<String> descriptions = readAllLines(get(this.location), defaultCharset());
            //TODO lazy loaded bean?
            return new ControlsTranslator(descriptions).translate();
        } catch (final IOException e) {
            throw new ReadSpecificationException("File not found: " + this.location, e);
        }
    }
}
