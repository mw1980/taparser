package org.mrr.controls.api;

import java.util.List;

/**
 * The class contains methods to descriptionsAsText the control description from external source (e.g. xml, or csv)
 */
public interface LoadDescriptionsStrategy {
    /**
     * Loads all the current registered controls as string descriptions.
     * @return a list with current known control descriptions.
     */
    List<String> descriptionsAsText();
}
