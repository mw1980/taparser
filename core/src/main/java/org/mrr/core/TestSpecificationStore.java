package org.mrr.core;

import java.util.List;

/**
 * The interface describes the api of a step description store.
 */
public interface TestSpecificationStore {
    /**
     * This method reads plain text test cases from an external source.
     *
     * @return List of string objects, each item contains a test specification line.
     */
    List<String> testDescriptions();
}
