package org.mrr.uielements;

import org.mrr.IdentificationType;
import org.mrr.ReadSpecificationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * The class contains methods to read from ui elements from external csv file.
 */
public class UiElementsCsvSupplier {
    /**
     * Location of the file that contains the user interface elements description.
     */
    private final String location;

    public UiElementsCsvSupplier(final String location) {
        this.location = location;
    }

    /**
     * Creates the ui elements from their desccription in the external file.
     *
     * @return List of Ui elements.
     * @throws ReadSpecificationException if the ui elements description cannot be read.
     */
    public Map<String, UiElement> createUiElements() {
        try {
            final List<String> descriptions = readAllLines(get(this.location), defaultCharset());
            return createUiElements(descriptions);
        } catch (final IOException e) {
            throw new ReadSpecificationException("File not found: " + this.location, e);
        }
    }

    private Map<String, UiElement> createUiElements(final List<String> descriptions) {
        final Map<String, UiElement> result = new HashMap<>();
        for (final String description : descriptions) {
            final String[] lineItems = description.split(" ");
            result.put(lineItems[0],
                    new UiElement(lineItems[0], IdentificationType.forValue(lineItems[1]), lineItems[2]));
        }
        return result;
    }
}
