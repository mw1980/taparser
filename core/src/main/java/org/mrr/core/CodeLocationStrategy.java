package org.mrr.core;

/**
 * Generic code location for an user interface control.
 */
public interface CodeLocationStrategy {
    /**
     * The method returns the test automation code that locates a control on the user interface.
     * Example: The selenium implementation should return something like: By.id("htmlId")
     *
     * @param value the user control identification value, like: controls id, or controls xpath
     * @return the identification code as string
     */
    String codeFor(String value);
}
