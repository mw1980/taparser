package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The class stores the information needed to locate a control on a html page.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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