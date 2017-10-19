package org.mrr.core;

/**
 * Generic code location for an user interface control.
 */
public interface CodeLocationType {
    /**
     * The method returns the test automation code that locates a control on the user interface.
     * Example: The selenium implementation should return something like: By.id("htmlId")
     *
     * @param value the user control to generate the code for.
     * @return identification code as string
     */
    String codeFor(String value);
}
