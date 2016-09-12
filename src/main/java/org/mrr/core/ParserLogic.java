package org.mrr.core;

import java.util.List;

/**
 * The main parser interface.
 */
interface ParserLogic {
    /**
     * Converts all the actions stored in the specification store to test automation code.
     *
     * @return List of test automation commands for the actioned described in the specification store.
     */
    List<String> parseSpecification();
}
