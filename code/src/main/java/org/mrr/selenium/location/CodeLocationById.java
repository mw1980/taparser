package org.mrr.selenium.location;

import org.mrr.core.CodeLocationStrategy;

import static java.lang.String.format;

public class CodeLocationById implements CodeLocationStrategy {
    @Override
    public String codeFor(final String value) {
        return format("By.id(\"%s\")", value);
    }
}