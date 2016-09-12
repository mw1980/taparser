package org.mrr.core;

import java.util.List;

/**
 * The interface describes the api of a step description store.
 */
public interface TestSpecificationStore {
    /**
     * This method reads test cases from an external text file.
     *
     * @return List of Strings, each element contains a line in the text file.
     */
    List<String> deliverTestDescriptions();
}
