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
//In order to preserve the file path injection in the constructor, the bean is defined in the ApplicationConfig class.
//Therefore no @Autowired and @Component annotation here...
public class FileTestSpecificationStoreImpl implements TestSpecificationStore {
    private String location;

    public FileTestSpecificationStoreImpl(final String specificationLocation) {
        this.location = specificationLocation;
    }

    @Override
    public List<String> deliverTestDescriptions() {
        try {
            return Files.readAllLines(Paths.get(location), Charset.defaultCharset());
        } catch (final IOException e) {
            throw new TestSpecificationException(e.getMessage());
        }
    }
}
