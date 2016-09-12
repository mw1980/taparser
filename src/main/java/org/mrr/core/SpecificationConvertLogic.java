package org.mrr.core;

import java.util.List;

/**
 * The main converter interface.
 */
interface SpecificationConvertLogic {
    /**
     * Converts all the action descriptions from the specification store to automation commands.
     *
     * @return List of automation commands, like Selenium, for the actions described in the specification store.
     */
    List<String> parseSpecification();
}
