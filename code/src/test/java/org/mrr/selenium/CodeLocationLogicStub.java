package org.mrr.selenium;


import org.mrr.api.CodeLocationLogic;

/**
 * Stub implementation of the CodeLocationLogic interface.
 */
class CodeLocationLogicStub implements CodeLocationLogic {
    @Override
    public String locationCodeFor(final String name) {
        return String.format("By.id(\"%sHtmlId\")", name);
    }
}
