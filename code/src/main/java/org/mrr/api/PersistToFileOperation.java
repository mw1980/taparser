package org.mrr.api;

import java.io.IOException;

import static java.lang.String.format;

/**
 * The interface handles the storing of the string information on the disk.
 */
public interface PersistToFileOperation {
    /**
     * The method contains the logic to execute a text to a external location (file).
     *
     * @param where the path to the file where the text should be saved.
     * @param what  the text that need to be saved.
     */
    void execute(String where, String what) throws IOException;

    final class DummyPersistToFileOperation implements PersistToFileOperation {

        @Override
        public void execute(final String where, final String what) throws IOException {
            //dummy, trigger no real action.
        }
    }

    final class PersistToFileOperationWithException implements PersistToFileOperation {
        @Override
        public void execute(final String where, final String what) throws IOException {
            throw new IOException(format("%s:%s", where, what));
        }
    }
}