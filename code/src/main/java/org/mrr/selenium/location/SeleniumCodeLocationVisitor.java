package org.mrr.selenium.location;

import org.mrr.core.CodeLocationType;
import org.mrr.core.CodeLocationVisitor;
import org.springframework.stereotype.Component;

/**
 * Selenium implementation for the CodeLocationVisitor interface.
 * It delivers the selenium classes that can generate the code location for elements with different
 * identification criteria.
 */
@Component
public class SeleniumCodeLocationVisitor implements CodeLocationVisitor {
    @Override
    public CodeLocationType codeLocationForId() {
        return new CodeLocationById();
    }

    @Override
    public CodeLocationType codeLocationForXPath() {
        return new CodeLocationByXPath();
    }

    @Override
    public CodeLocationType codeLocationForUnknownCriteria() {
        return new CodeLocationUnknown();
    }
}
