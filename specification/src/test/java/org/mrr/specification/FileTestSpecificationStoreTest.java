package org.mrr.specification;

import org.junit.jupiter.api.Test;
import org.mrr.core.TestSpecificationException;

import static org.junit.jupiter.api.Assertions.assertThrows;


class FileTestSpecificationStoreTest {

    @Test
    void whenReadingNotExistingFile_shouldThrowException() {
        assertThrows(
                TestSpecificationException.class,
                () -> new FileTestSpecificationStore("NotExistingFile.txt").testDescriptions()
        );
    }
}
