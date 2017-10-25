package org.mrr.reader.txt.controls;

import org.mrr.core.LoadControlsException;
import org.mrr.reader.txt.controls.api.ControlDescriptions;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * The class contains methods to read controls descriptions from an csv file.
 */
public class CsvControlDescriptions implements ControlDescriptions {

    private final String location;

    public CsvControlDescriptions(final String fileLocation) {
        this.location = fileLocation;
    }

    @Override
    public List<String> allDescriptions() {
        try {
           return readAllLines(get(this.location), defaultCharset());
        } catch (final IOException e) {
            throw new LoadControlsException("File not found: " + this.location, e);
        }
    }
}
