package org.mrr.core;

import java.util.List;

public interface CodeSpecificationLogic {
    /**
     * Converts all the action descriptions from the specification store to automation commands.
     *
     * @return List of {@link CodedTestAction} objects, like Selenium, for the actions described in the specification store.
     */
    List<CodedTestAction> codeForSpecification();
}
