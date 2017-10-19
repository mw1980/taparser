package org.mrr.selenium.location;

import org.mrr.core.CodeLocationType;

import static java.lang.String.format;

public class CodeLocationById implements CodeLocationType {
    @Override
    public String codeFor(final String value) {
        return format("By.id(\"%s\")", value);
    }
}