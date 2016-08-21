package org.mrr.controls.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.domain.IdentificationCriteria;

/**
 * The class stores the information needed to locate a control on a html page.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UiLocator {
    private final IdentificationCriteria identificationCriteria;
    private final String value;

    IdentificationCriteria identificationCriteria() {
        return identificationCriteria;
    }

    public String value() {
        return value;
    }
}
