package org.mrr.core.domain;

import org.mrr.core.CodeLocationStrategy;
import org.mrr.core.CodeLocationVisitor;

import static org.apache.commons.lang3.StringUtils.equalsAnyIgnoreCase;

/**
 * The class contains the identification criteria for a user interface element on the gui.
 * Example: byId, byName, byXPath, ByCss.
 */
//TODO: externalise the matchesDescription logic.
public enum IdentificationCriteria {
    ID {
        @Override
        public boolean matchesDescription(final String description) {
            return equalsAnyIgnoreCase(description, "by id", "id", "byId");
        }

        @Override
        public CodeLocationStrategy codeLocationStrategy(final CodeLocationVisitor visitor) {
            return visitor.codeLocationForId();
        }

    }, UNKNOWN {
        @Override
        public boolean matchesDescription(final String description) {
            return false;
        }

        @Override
        public CodeLocationStrategy codeLocationStrategy(final CodeLocationVisitor visitor) {
            return visitor.codeLocationForUnknownCriteria();
        }
    }, XPATH {
        @Override
        public boolean matchesDescription(final String description) {
            return equalsAnyIgnoreCase(description, "by xpath", "xpath", "byXpath");
        }

        @Override
        public CodeLocationStrategy codeLocationStrategy(final CodeLocationVisitor visitor) {
            return visitor.codeLocationForXPath();
        }
    };

    public abstract boolean matchesDescription(String description);

    public abstract CodeLocationStrategy codeLocationStrategy(CodeLocationVisitor visitor);

}
