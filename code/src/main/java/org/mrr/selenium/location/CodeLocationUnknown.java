package org.mrr.selenium.location;

import org.mrr.api.CodeException;
import org.mrr.core.CodeLocationStrategy;

/**
 * CodeLocationStrategy implementation for the unknown element types.
 */
public class CodeLocationUnknown implements CodeLocationStrategy {
    @Override
    public String codeFor(final String value) {
        throw new CodeException(
                String.format("Identification type for %s is unknown.", value));
    }
}
