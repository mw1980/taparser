package org.mrr.selenium.location;

import org.mrr.core.CodeLocationStrategy;

import static java.lang.String.format;

/**
 * The class deals with automation code to locate an user interface element by XPath.
 */
public class CodeLocationByXPath implements CodeLocationStrategy {
    @Override
    public String codeFor(final String value) {
        return format("By.xpath(\"%s\")", value);
    }
}
