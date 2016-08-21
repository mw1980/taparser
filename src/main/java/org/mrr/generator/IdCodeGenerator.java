package org.mrr.generator;

/**
 * The interface contains methods to generate the test automation code to identify user interface controls.
 */
public interface IdCodeGenerator {
    /**
     * Returns the automation code used to identify the user interface control with the name received as parameter.
     * E.g. for a control with name "login" it returns the code that identifies the element on the surface,
     * something like: By.Id("login_id");
     */
    String identificationCodeFor(String name);
}