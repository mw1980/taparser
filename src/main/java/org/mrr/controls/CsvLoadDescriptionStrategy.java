package org.mrr.controls;

import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.mrr.core.LoadControlsException;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * The class contains methods to read controls descriptions from an csv file.
 */
//No @Component, the bean is declared in the ApplicationConfig class.
public class CsvLoadDescriptionStrategy implements LoadDescriptionsStrategy {

    private final String location;

    public CsvLoadDescriptionStrategy(final String fileLocation) {
        this.location = fileLocation;
    }

    @Override
    public List<String> loadDescriptions() {
        try {
           return readAllLines(get(this.location), defaultCharset());
        } catch (final IOException e) {
            throw new LoadControlsException("File not found: " + this.location, e);
        }
    }
}
