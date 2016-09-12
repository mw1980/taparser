package org.mrr.generator.selenium;

import org.mrr.generator.LocatorCodeGenerator;

/**
 * Stub implementation of the LocatorCodeGenerator interface.
 */
class LocatorCodeGeneratorStub implements LocatorCodeGenerator {
    @Override
    public String identificationCodeFor(final String name) {
        return "By.id(\"" + name + "HtmlId\")";
    }
}
