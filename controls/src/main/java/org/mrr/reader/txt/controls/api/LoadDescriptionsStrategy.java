package org.mrr.reader.txt.controls.api;

import java.util.List;

/**
 * The interface defines the methods used to load the controls descriptions from external source (e.g. xml, or csv)
 */
public interface LoadDescriptionsStrategy {
    /**
     * Loads all the current registered controls as string descriptions.
     * @return a list with current known control descriptions.
     */
    List<String> loadDescriptions();
}
