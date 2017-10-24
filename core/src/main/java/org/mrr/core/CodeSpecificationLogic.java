package org.mrr.core;

import java.util.List;

public interface CodeSpecificationLogic {
    /**
     * Converts all the registered test action descriptions to their correspondent automation commands.
     *
     * @return List of {@link CodedAction} objects.
     */
    List<CodedAction> codeForSpecification();
}
