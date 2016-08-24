package org.mrr.core;

import java.util.List;

/**
 * The interface describes the api of a step description store.
 */
public interface TestSpecificationStore {

    List<String> deliverTestDescriptions();
}
