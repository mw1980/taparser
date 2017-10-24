package org.mrr.api;

/**
 * The interface contains methods to generate the test automation code to identify user interface controls.
 */
public interface CodeLocationLogic {
    /**
     * Returns the automation code used to identify the user interface control with the name received as parameter.
     * E.g. for a control with name "login" it returns the code that identifies the element on the surface,
     * something like: By.id("login_id");
     */
    String locationCodeFor(String name);
}