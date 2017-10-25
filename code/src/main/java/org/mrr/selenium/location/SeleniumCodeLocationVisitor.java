package org.mrr.selenium.location;

import org.mrr.core.CodeLocationStrategy;
import org.mrr.core.CodeLocationVisitor;
import org.springframework.stereotype.Component;

/**
 * Selenium implementation of the CodeLocationVisitor interface.
 * It delivers the selenium classes that can generate the code location for elements with different
 * identification criteria.
 */
@Component
public class SeleniumCodeLocationVisitor implements CodeLocationVisitor {
    @Override
    public CodeLocationStrategy codeLocationForId() {
        return new CodeLocationById();
    }

    @Override
    public CodeLocationStrategy codeLocationForXPath() {
        return new CodeLocationByXPath();
    }

    @Override
    public CodeLocationStrategy codeLocationForUnknownCriteria() {
        return new CodeLocationUnknown();
    }
}
