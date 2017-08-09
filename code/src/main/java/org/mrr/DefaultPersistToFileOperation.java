package org.mrr;

import org.mrr.api.PersistToFileOperation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Default implementation of the persist to file operation.
 */
@Component
public class DefaultPersistToFileOperation implements PersistToFileOperation {
    @Override
    public void execute(final String where, final String what) throws IOException {
        Files.write(Paths.get(where), what.getBytes());
    }
}