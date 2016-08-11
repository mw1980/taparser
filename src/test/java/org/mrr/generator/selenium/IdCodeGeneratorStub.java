package org.mrr.generator.selenium;

import org.mrr.generator.IdCodeGenerator;

/**
 * Stub implementation of the IdCodeGenerator interface.
 */
class IdCodeGeneratorStub implements IdCodeGenerator {
    @Override
    public String identificationCodeFor(final String name) {
        return "By.id(\"" + name + "HtmlId\")";
    }
}
