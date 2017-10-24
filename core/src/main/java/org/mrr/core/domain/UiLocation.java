package org.mrr.core.domain;

import lombok.Value;

/**
 * The class stores the information needed to locate a control on a html page.
 */
@Value
public class UiLocation {
    private final IdentificationCriteria identificationCriteria;
    private final String value;

    IdentificationCriteria identificationCriteria() {
        return identificationCriteria;
    }

    public String value() {
        return value;
    }
}
