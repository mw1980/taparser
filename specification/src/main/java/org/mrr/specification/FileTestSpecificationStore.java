package org.mrr.specification;


import org.mrr.core.TestSpecificationException;
import org.mrr.core.TestSpecificationStore;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class contains methods for reading test cases from an external file.
 */
public class FileTestSpecificationStore implements TestSpecificationStore {
    private String location;

    public FileTestSpecificationStore(final String specificationLocation) {
        this.location = specificationLocation;
    }

    @Override
    public List<String> testDescriptions() {
        try {
            return Files.readAllLines(Paths.get(location), Charset.defaultCharset());
        } catch (final IOException e) {
            throw new TestSpecificationException(e.getMessage());
        }
    }
}
