package org.mrr.generate.selenium;


import org.mrr.LocatorCodeGenerator;

/**
 * Stub implementation of the LocatorCodeGenerator interface.
 */
class LocatorCodeGeneratorStub implements LocatorCodeGenerator {
    @Override
    public String identificationCodeFor(final String name) {
        return String.format("By.id(\"%sHtmlId\")", name);
    }
}