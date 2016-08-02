package org.mrr.controls;

import org.mrr.ReadSpecificationException;
import org.mrr.controls.api.LoadDescriptionsStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * The class contains methods to descriptionsAsText controls descriptions from an csv file.
 */
@Component
class CsvLoadDescriptionStrategy implements LoadDescriptionsStrategy {
    @Value("${controls.description.location}")
    private String location;

    @Override
    public List<String> descriptionsAsText() {
        try {
           return readAllLines(get(this.location), defaultCharset());
        } catch (final IOException e) {
            throw new ReadSpecificationException("File not found: " + this.location, e);
        }
    }
}